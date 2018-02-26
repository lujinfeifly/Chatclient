package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

public class PacketActivitySDMsg extends PacketBase {
	@Mapping("giftId")
	private long giftId;//礼物id
	@Mapping("type")
	private int acType; //类型
	@Mapping("progress")
	private int progress;//进度
	@Mapping("uuid")
	private String uuid; //uuid
	@Mapping("time")
	private int time; //服务器时间
	
	public int getAcType() {
		return acType;
	}
	public void setAcType(int acType) {
		this.acType = acType;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public long getGiftId() {
		return giftId;
	}
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	@Override
	public String toString() {
		return "PacketActivitySDMsg [acType=" + acType + ", progress=" + progress + ", uuid=" + uuid + ", time=" + time
				+ "]";
	}
}
