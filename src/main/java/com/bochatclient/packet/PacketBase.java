package com.bochatclient.packet;



public class PacketBase {
	
	protected int retcode;
	protected int type;//packet包类型
	
	public int getRetcode() {
		return retcode;
	}
	public int getType() {
		return type;
	}
	
}
