package com.bochatclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONObject;

import com.bochatclient.enter.QueryListBean;
import com.bochatclient.enter.SendBean;
import com.bochatclient.enter.TalkBean;
import com.bochatclient.enter.UserEnterBean;
import com.bochatclient.enter.UserMsgBean;
import com.bochatclient.enums.ErrorEnum;
import com.bochatclient.listener.ErrorListener;
import com.bochatclient.listener.MsgListener;
import com.bochatclient.packet.PacketBase;
import com.bochatclient.packet.PacketIntent;
import com.bochatclient.utils.BeanUtil;
import com.bochatclient.utils.URLEncode;
 
public class BoChat {
    private SocketChannel client;
    private Selector selector = getSelector();
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(20));
 
    private MsgListener msgListener = null;
	private ErrorListener errorListener = null;
    private UserEnterBean loginBean;
	
	
    private volatile boolean isClose = false;
 
    private AtomicLong writeCount = new AtomicLong(0);
    private AtomicLong readCount = new AtomicLong(0);
 
    private AtomicBoolean isWriting = new AtomicBoolean(false);
    private AtomicBoolean isReading = new AtomicBoolean(false);
 
    /**
	 * 
	 * @param msgListener
	 */
	public void setMsgListener(MsgListener msgListener) {
		this.msgListener = msgListener;
	}
	
	public void setErrorListener(ErrorListener errorListener) {
		this.errorListener = errorListener;
	}
    
    public Selector getSelector() {
        try {
            return Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public BoChat(String ip,int port) {
        try {
            client = SocketChannel.open();
            client.configureBlocking(false);
            client.connect(new InetSocketAddress(ip,port));
            client.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            System.out.println("创建客户端连接异常Client2" + e.getMessage());
            close();
        }
 
    }
 
    public void start() {
    	threadPool.execute(new SelectorGuardHandler());
    	threadPool.execute(new HeartBeatThread());
    }
 
    private class SelectorGuardHandler implements Runnable {
 
        @Override
        public void run() {
 
            while (!isClose) {
                try {
                    if (selector.select(10) == 0) {
                        continue;
                    }
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if (selectionKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            if (isReading.get()) {
                                Thread.sleep(5);
                            } else {
                                isReading.set(true);
                                threadPool.execute(new ReceiveMessageHandler(socketChannel));
                            }
                        } else if (selectionKey.isWritable()) {
                            Object requestMessage = selectionKey.attachment();
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            selectionKey.interestOps(SelectionKey.OP_READ);
                            threadPool.execute(new SendMessageHandler(socketChannel, requestMessage));
                        } else if (selectionKey.isConnectable()) {
                            SocketChannel sc = (SocketChannel) selectionKey.channel();
                            sc.finishConnect();
                            sc.register(selector, SelectionKey.OP_READ);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("客户端启动或运行异常[start]：" + e.getMessage());
                    close();
                }
            }
        }
    }
 
    /**
     * 发送数据线程
     * 
     * @author renms
     * 
     */
    private class SendMessageHandler implements Runnable {
        private SocketChannel client;
 
        private Object requestMessage;
 
        private SendMessageHandler(SocketChannel client, Object requestMessage) {
            this.client = client;
            this.requestMessage = requestMessage;
        }
 
        @Override
        public void run() {
            try {
                byte[] requestMessageByteData = null;
                if (requestMessage instanceof byte[]) {
                    requestMessageByteData = (byte[]) requestMessage;
                } else if (requestMessage instanceof String) {
                    requestMessageByteData = ((String) requestMessage).getBytes();
                }
                if (requestMessageByteData == null || requestMessageByteData.length == 0) {
                    System.out.println("客户端发送的数据为空");
                } else {
                    ByteBuffer data = ByteBuffer.allocate(requestMessageByteData.length + 4);//4个字节代表包长度
                    data.putInt(requestMessageByteData.length+4);
                    data.put(requestMessageByteData);
                    data.flip();
                    while (data.hasRemaining()) {
                        client.write(data);
                    }
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                    System.out.println("[" + sdf.format(date) + "]客户端发送数据：["
                            + new String(requestMessageByteData) + "]");
                }
            } catch (Exception e) {
                System.out.println("客户端发送数据失败：[" + e.getMessage() + "]");
                close();
            } finally {
                isWriting.set(false);
                writeCount.decrementAndGet();
            }
        }
    }
 
    /**
     * 读数据线程
     * 
     * @author renms
     * 
     */
    private class ReceiveMessageHandler implements Runnable {
        private SocketChannel client;
        private ByteBuffer dataLen = ByteBuffer.allocate(8);
 
        private ReceiveMessageHandler(SocketChannel client) {
            this.client = client;
        }
 
        @Override
        public void run() {
            try {
                dataLen.clear();
                int len = 8;
                while (len > 0) {
                    int readLen = client.read(dataLen);
                    if (readLen < 0) {
                    	//服务器主动断开连接，关闭相关流信息
                    	close();
                    	return;
//                        throw new Exception("readLen==" + readLen);
                    } else if (readLen == 0) {
                        System.out.println(Thread.currentThread().getId() + "readLen == 0");
                        return;
                    }
                    len -= readLen;
                }
                dataLen.flip();
                int data_length = dataLen.getInt()&0xffff;
                int action = dataLen.get()&0xff;
                int type = dataLen.get()&0xff;
                
                ByteBuffer data = ByteBuffer.allocate(data_length-8);
                while (data.hasRemaining()) {
                    client.read(data);
                }
                
                byte[] ss = URLEncode.unjzlib(data.array());
                String receiveData = new String(ss,"UTF-8");
                
                List<PacketBase> packetList = PacketIntent.getPacket(action, type, receiveData);
                if(packetList!=null){
	                for(int i=0,size=packetList.size();i<size;i++){
	                	PacketBase packet = packetList.get(i);
						if(packet != null){
							int retCode = packet.getRetcode();
							if(retCode==0){
								msgListener.onReciveMsg(packet);
							}else{
								errorListener.onError(retCode,ErrorEnum.getErrorMsg(retCode));
							}
						}
	                }
                }
                
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                System.out.println("[" + sdf.format(date) + "] 数据 :[action:"+action+"--type:"+type+ "--content:" + receiveData + "]");
                readCount.incrementAndGet();
            } catch (Exception e) {
            	e.printStackTrace();
                System.out.println("客户端接收数据失败：" + e);
                close();
            } finally {
                isReading.set(false);
            }
        }
    }
    
    private class HeartBeatThread implements Runnable {
		public void run() {
			while(!isClose) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				//发送心跳包
				writeBytes(getHeartBeatPacket());
			}
		}
	}
 
    public boolean isClose() {
        return isClose;
    }
 
    public void setClose(boolean close) {
        this.isClose = close;
    }
 
    public void close() {
        try {
            threadPool.shutdown();
            isClose = true;
            if (selector != null) {
                selector.close();
            }
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            System.out.println("关闭客户端异常：" + e.getMessage());
        }
    }
 
    public void writeBytes(byte[] data) {
        while (isWriting.get()) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            isWriting.set(true);
            writeCount.incrementAndGet();
            client.register(selector, SelectionKey.OP_WRITE, data);
        } catch (Exception e) {
            System.out.println("客户端注册写通道异常：" + e.getMessage());
        }
    }
 
    public boolean hasWriteTask() {
        return writeCount.get() != 0;
    }
 
    public long getRecive() {
        return readCount.get();
    }
    
    
    public void enterroom(UserEnterBean loginBean) {
    	this.loginBean = loginBean;
		try {
			this.writeBytes(encodePacket(0, 0,loginBean));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
	 * 
	 * @param msg	消息内容
	 * @param action	消息类型：0：对大家说；1：对某人公开说；2：对某人私聊
	 * @param toMasterId	action为1，2时 接收消息人
	 * @param toMasterNick
	 */
	public void sendMessage(String msg,int action,String toMasterId,String toMasterNick) {
		try {
			this.writeBytes(encodePacket(action, 2,new TalkBean(msg,action,toMasterId,toMasterNick)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 观众列表
	 * @param pno
	 * @param rpp
	 */
	public void sendQueryList(String pno, String rpp ) {
		try {
			this.writeBytes(encodePacket(0, 6,new QueryListBean(loginBean.getRid(), loginBean.getUid(), pno, rpp)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 观众数量
	 * @param uid
	 */
	public void sendQueryUserMsg(String uid) {
		try {
			this.writeBytes(encodePacket(4, 2,new UserMsgBean(loginBean.getRid(), loginBean.getUid(), uid)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//-----------------------------获取发送包的字符数组------------------------------
	
	//心跳包
	public byte[] getHeartBeatPacket() {
		byte[] ret = new byte[5];
		ret[0] = 3;
		ret[1] = 0;
		ret[4] = '1';
		return ret;
	}
	
	private byte[] encodePacket(int action,int type,SendBean bean){
		JSONObject job = new JSONObject(BeanUtil.beanToJson(bean));
		byte[] packetContent = job.toString().getBytes();
		
		int len = packetContent.length;
		byte[] ret = new byte[len+4];

		ret[0]=(byte)action;
		ret[1]=(byte)type;
		for (int i = 0; i < len; i++) {
			ret[i+4] = packetContent[i];
		}
		return ret;
	}
}