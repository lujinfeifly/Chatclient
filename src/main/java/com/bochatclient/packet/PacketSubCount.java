package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;


public class PacketSubCount extends PacketBase {
	
	@Mapping("masterId")
	private int masterId;
	@Mapping("count")
	private int count;
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PacketSubCount [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", masterId="
				+ masterId + ", count=" + count + "]";
	}
}
