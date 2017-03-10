package com.bochatclient.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.bochatclient.BoException;
import com.bochatclient.URLEncode;
import com.bochatclient.packet.PacketBase;
import com.bochatclient.packet.PacketIntent;

public class InputCircleBuffer {
	
	private static int LEN = 10240;
	
	private byte[] buffer = new byte[LEN];
	
	private int begin = 0;
	private int end = 0;
	
	public int leftSize() {
		if(end > begin) {
			return LEN - end + begin;
		}else if(begin == end){
			return LEN - 1;
		}else {
			return begin - end;
		}
	}
	
	public int size() {
		if(end > begin) {
			return end - begin;
		}else if(begin == end){
			return 0;
		}else {
			return LEN - begin + end;
		}
	}
	
	public int readFromInputStream(InputStream stream) throws BoException, IOException {
		if(leftSize() > 20) { // ���ʣ��ռ����
			int firstReadLen = (end >= begin)? (LEN - end) : (begin - end - 1);
			int readbyte = stream.read(buffer, end, firstReadLen);
			System.out.println("lem:" + readbyte + "," + end + "," + firstReadLen);
			if(readbyte == -1) {
				throw new BoException(100,"Server disconnected.");
			}
			int secondReadLen = (end >= begin)? begin - 1: 0;
			int readbyte2 = 0;
			end += readbyte;
			if(firstReadLen > readbyte) { // �ռ��㹻
				//end += readbyte;
			}else { // �ռ䲻��
				if(secondReadLen > 0) {
					readbyte2 = stream.read(buffer, 0, secondReadLen);
//					System.out.println("lem2:" + readbyte2 + "," + 0 + "," + secondReadLen);
					if(readbyte2 == -1) {
						throw new BoException(100,"Server disconnected.");
					} else if(readbyte2 == 0) {
						end = LEN - 1;
					} else {
						end = readbyte2;
					}
				}
			}
			return readbyte + readbyte2;
		}
		return 0;
	}
	
	public PacketBase getPacket() {
		int size = size();
		if(size < 8) {
			return null;
		}
		int a = buffer[begin] &0xff;
		int b = buffer[(begin + 1)%LEN]&0xff;
		int c = buffer[(begin + 2)%LEN]&0xff;
		int d = buffer[(begin + 3)%LEN]&0xff;
		int action = buffer[(begin + 4)%LEN]&0xff;
		int type = buffer[(begin + 5)%LEN]&0xff;
		int g = buffer[(begin + 6)%LEN]&0xff;
		int h = buffer[(begin + 7)%LEN]&0xff;
		
		int len = (a<<24) + (b<<16) + (c<<8) + d;
		
//		System.out.println("hduhuhuhuhuh:"+ begin + ",,,,,"       + a + "," + b + ","+ c + "," + d + ",");
		
		if(len>2000 || len<0) {
			int s = 1;
			int v = 7;
			v = s;
		}
		if(len > size){
			return null;
		}
		

		byte[] tempcontent = new byte[len - 8];
		for(int i=0;i<len - 8;i++ ) {
			tempcontent[i] = buffer[(begin + 8 + i)%LEN];
		}
		
		begin += len;
		begin %= LEN;
		
		
		byte[] ss = URLEncode.unjzlib(tempcontent);
		try{
			System.out.println("action:" + action+", type:"+ type + "," + new String(ss, "UTF-8"));
		} catch(Exception ex) {
			
		}
		
		
		PacketBase packet = null;
		try {
			packet = PacketIntent.getPacket(action, type, new String(ss, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		return packet;
	}

}
