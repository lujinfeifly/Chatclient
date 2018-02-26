package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

public class PacketActivityGift extends PacketBase {
	@Mapping("a")
	private int type;//展现类型
	@Mapping("c")
	private long masterNo;//主播靓号
	@Mapping("d")
	private String msg; //app端消息
	@Mapping("e")
	private String giftName;//礼物名称
	@Mapping("f")
	private boolean issd;//是否是圣诞节
	@Mapping("g")
	private long roleId;//角色id
	@Mapping("h")
	private long roomId;//直播间id
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getMasterNo() {
		return masterNo;
	}
	public void setMasterNo(long masterNo) {
		this.masterNo = masterNo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public boolean isIssd() {
		return issd;
	}
	public void setIssd(boolean issd) {
		this.issd = issd;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "PacketActivityGift [type=" + type + ", masterNo=" + masterNo + ", msg=" + msg + ", giftName=" + giftName
				+ ", issd=" + issd + ", roleId=" + roleId + ", roomId=" + roomId + "]";
	}
	
}
