package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketPkProgressMsg.java
 * @Description: PK进度条
 * @author renms
 * @date 2018年3月14日 下午2:24:19 
 * @version 1.0
 */
public class PacketPkProgressMsg extends PacketBase{
	
	
	@Mapping("a")
	private int masterid;//排名
	@Mapping("b")
	private long prValue;//进度条值
	
	public int getMasterid() {
		return masterid;
	}
	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}
	public long getPrValue() {
		return prValue;
	}
	public void setPrValue(long prValue) {
		this.prValue = prValue;
	}
	
	@Override
	public String toString() {
		return "PacketPkProgressMsg [masterid=" + masterid + ", prValue=" + prValue + "]";
	}
	
}