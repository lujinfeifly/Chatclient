package com.bochatclient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.bochatclient.buffer.InputCircleBuffer;
import com.bochatclient.listener.ErrorListener;
import com.bochatclient.listener.MsgListener;
import com.bochatclient.packet.PacketBase;
import com.bochatclient.packet.PacketIntent;
import com.google.gson.Gson;
import com.jcraft.jzlib.ZInputStream;

public class BoChatClient {
	private String mIp;
	private int mPort;
	private UserEnterBean loginBean;
	
	private Socket s = null;
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	private boolean bConnected = false;
	private boolean bStop = false;
	
	private MsgListener msgListener = null;
	private ErrorListener errorListener = null;

	private byte[] recvBuf = new byte[10240];
	
	private Object lock = new Object();

	Thread tRecv = new Thread(new RecvThread());

	Thread heartBeat = new Thread(new HeartBeatThread());
	
	InputCircleBuffer buffer = new InputCircleBuffer();
	
	public BoChatClient() {
	}
	
	/**
	 * 
	 * @param ip
	 * @param port
	 */
	public BoChatClient(String ip, int port) {
		this.mIp = ip;
		this.mPort = port;
	}
	
	public void setLoginBean(UserEnterBean loginBean) {
		this.loginBean = loginBean;
	}

	/**
	 * ������Ϣ���յĻص�
	 * @param msgListener
	 */
	public void setMsgListener(MsgListener msgListener) {
		this.msgListener = msgListener;
	}
	
	public void setErrorListener(ErrorListener errorListener) {
		this.errorListener = errorListener;
	}

	/**
	 * ���÷�������ip�Ͷ˿�
	 * @param ip
	 * @param port
	 */
	public void setIpPort(String ip, int port) {
		this.mIp = ip;
		this.mPort = port;
	}
	
//	public void reConnect() {
//		tRecv.stop();
//		heartBeat.stop();
//		disconnect();
//		connect();
//		
//		tRecv.start();
//		heartBeat.start();
//		
//	}
	
	public void start() {
		tRecv.start();
		heartBeat.start();
	}

	public void enterroom() {
		try {
			dos.write(getEnterPacket(loginBean));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg) {
		try {
			dos.write(getMsgPacket(msg));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			s = new Socket(mIp, mPort);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			System.out.println("~~~~~~~~连接成功~~~~~~~~!");
			bConnected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void disconnect() {
		try {
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class RecvThread implements Runnable {
		public void run() {
			while (!bStop) {
				synchronized (lock) {
					try{
						buffer.readFromInputStream(dis);
						PacketBase packet = buffer.getPacket();
							
						if(packet != null)
						switch(packet.getRetcode()) {
						case 0:       
							if(packet.isMsg()) {
								msgListener.onReciveMsg(packet);
							}
							break;
						case 1:        // ͨ�ô���
							errorListener.onError(1);
							break;
						case 2:        // �������
							break;
						case 401001:
							break;
						case 401002:
							break;
						case 401005:   // ��Ч����id
							break;
						case 401014:    // 
							break;
						case 409004:
							break;
						case 409005:
							break;
						case 401007:
							break;
						case 401011:
							break;
						case 402001:
							break;
						case 402003:
							break;
						case 402004:
							break;
						case 402005:
							break;
						case 402007:
							break;
						case 402009:
							break;
						case 402010:
							break;
						case 402012:
							break;
						case 402013:
							break;
						case 402014:
							break;
						case 402015:
							break;
						case 402016:
							break;
						case 402008:
							break;
						case 402017:
							break;
						case 403001:
							break;
						case 403002:
							break;
						case 404001:
							break;
						case 404002:
							break;
						default:
							
						}
							
//						} else {
//							try {
//								Thread.sleep(80);
//							} catch (InterruptedException e) {
//							}
//						}
					}catch(SocketException se) {
						se.printStackTrace();
					}catch(IOException e) {
						e.printStackTrace();
					}catch(BoException be) {
						errorListener.onError(2);
						break;
					}
				}
				
			}
		}
	}

	private class HeartBeatThread implements Runnable {
		public void run() {
			while(!bStop) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			
				if (bConnected) {
					try {
						dos.write(getHeartBeatPacket());
					} catch (SocketException se) {
						se.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("heart ! ");
				}
			}
		}
	}

	public byte[] getHeartBeatPacket() {
		byte[] ret = new byte[9];
		ret[3] = 9;
		ret[4] = 3;
		ret[5] = 0;
		ret[8] = '1';
		return ret;
	}

	public byte[] getEnterPacket(UserEnterBean bean) {
		byte[] packetContent = (new Gson()).toJson(bean).getBytes();
		int len = packetContent.length;
		byte[] ret = new byte[8 + len];

		int headint = len + 8;
		ret[0] = (byte) (headint >> 24 & 0xff);
		ret[1] = (byte) (headint >> 16 & 0xff);
		ret[2] = (byte) (headint >> 8 & 0xff);
		ret[3] = (byte) (headint & 0xff);
		for (int i = 0; i < len; i++) {
			ret[8 + i] = packetContent[i];
		}
		return ret;
	}
	
	public byte[] getMsgPacket(String msg) {
		byte[] packetContent = (new Gson()).toJson(new TalkBean(msg)).getBytes();
		int len = packetContent.length;
		byte[] ret = new byte[8 + len];

		int headint = len + 8;
		ret[0] = (byte) (headint >> 24 & 0xff);
		ret[1] = (byte) (headint >> 16 & 0xff);
		ret[2] = (byte) (headint >> 8 & 0xff);
		ret[3] = (byte) (headint & 0xff);
		
		ret[4] = 0;
		ret[5] = 2;
		
		for (int i = 0; i < len; i++) {
			ret[8 + i] = packetContent[i];
		}
		return ret;
	}
}