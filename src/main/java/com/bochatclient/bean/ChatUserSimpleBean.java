package com.bochatclient.bean;

public class ChatUserSimpleBean {
	
	private int userId;//用户id
	private int caifuLevel;//财富等级
	private String icon;//用户头像id
	private boolean isMaster;//是否是主播
	private int masterLevel;//主播等级
	private int charmLevel;//魅力等级
	private String userName;//用户昵称
//	private String roleId;//角色id
	private int userType;
	private String zoneName;//大区名称
	private int fensiLevel;//粉丝等级
	private String[] roomRoles;//房间角色,一个人可能承担多个角色
	
	private ExtraInfoBean extraInfo;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCaifuLevel() {
		return caifuLevel;
	}
	public void setCaifuLevel(int caifuLevel) {
		this.caifuLevel = caifuLevel;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isMaster() {
		return isMaster;
	}
	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}
	public int getMasterLevel() {
		return masterLevel;
	}
	public void setMasterLevel(int masterLevel) {
		this.masterLevel = masterLevel;
	}
	
	public int getCharmLevel() {
		return charmLevel;
	}
	public void setCharmLevel(int charmLevel) {
		this.charmLevel = charmLevel;
	}
	public String[] getRoomRoles() {
		return roomRoles;
	}
	public void setRoomRoles(String[] roomRoles) {
		this.roomRoles = roomRoles;
	}
	//	public String getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(String roleId) {
//		this.roleId = roleId;
//	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public int getFensiLevel() {
		return fensiLevel;
	}
	public void setFensiLevel(int fensiLevel) {
		this.fensiLevel = fensiLevel;
	}
	
	public ExtraInfoBean getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(ExtraInfoBean extraInfo) {
		this.extraInfo = extraInfo;
	}
	@Override
	public String toString() {
		return "ChatUserSimpleBean [userId=" + userId + ", caifuLevel="
				+ caifuLevel + ", icon=" + icon + ", isMaster=" + isMaster
				+ ", masterLevel=" + masterLevel + ", userName=" + userName
				+ ", userType=" + userType
				+ ", zoneName=" + zoneName + ", fensiLevel=" + fensiLevel + "]";
	}
}
