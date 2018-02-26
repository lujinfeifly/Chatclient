package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

public class PacketGiftFMsg extends PacketBase {
	@Mapping("a")
	private long giftId;	//礼物ID
	@Mapping("b")
	private String userName; //用户昵称
	@Mapping("c")
	private long roleId;//送礼人roleId
	@Mapping("d")
	private int fensiLevel; //粉丝等级
	@Mapping("e")
	private int caifuLevel; //财富等级
	@Mapping("f")
	private int userId; //用户的uid
	@Mapping("g")
	private String guid;//角色guid
	@Mapping("h")
	private int version;//版本号
	public long getGiftId() {
		return giftId;
	}
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public int getFensiLevel() {
		return fensiLevel;
	}
	public void setFensiLevel(int fensiLevel) {
		this.fensiLevel = fensiLevel;
	}
	public int getCaifuLevel() {
		return caifuLevel;
	}
	public void setCaifuLevel(int caifuLevel) {
		this.caifuLevel = caifuLevel;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "PacketGiftFMsg [retcode=" + retcode + ", retmsg=" + retmsg + ", type=" + type + ", giftId=" + giftId
				+ ", userName=" + userName + ", roleId=" + roleId + ", fensiLevel=" + fensiLevel + ", caifuLevel="
				+ caifuLevel + ", userId=" + userId + ", guid=" + guid + ", version=" + version + "]";
	}
	
}
