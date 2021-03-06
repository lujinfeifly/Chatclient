package com.bochatclient.bean;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.utils.GuidUtil;

public class ChatUserSimpleBean {
	
	@Mapping("bb")
	private int userId;//用户id
	@Mapping("h")
	private int caifuLevel;//财富等级
	@Mapping("j")
	private String icon;//用户头像id
	@Mapping("l")
	private boolean master;//是否是主播
	@Mapping("o")
	private int masterLevel;//主播等级
	@Mapping("d")
	private int charmLevel;//魅力等级
	@Mapping("p")
	private String userName;//用户昵称
	@Mapping("a4")
	private String guid;//角色id
	@Mapping("y")
	private long roleId;//角色id
	@Mapping("a8")
	private int userType;
	@Mapping("b1")
	private String zoneName;//大区名称
	@Mapping("b3")
	private int fensiLevel;//粉丝等级
	@Mapping("a1")
	private String roomRoles;//房间角色,一个人可能承担多个角色
	@Mapping("a2")
	private long sortNum;//粉丝等级

	@Mapping("c4")
	private String hasQs;//情圣标识-0-没尾灯/1-有尾灯
	
	@Mapping(value="g",type="object")
	private ExtraInfoBean extraInfo;
	
	public String getHasQs() {
		return hasQs;
	}
	public void setHasQs(String hasQs) {
		this.hasQs = hasQs;
	}
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
		return master;
	}
	public void setMaster(boolean master) {
		this.master = master;
	}
	public int getMasterLevel() {
		return masterLevel;
	}
	public void setMasterLevel(int masterLevel) {
		this.masterLevel = masterLevel;
	}
	public long getSortNum() {
		return sortNum;
	}
	public void setSortNum(long sortNum) {
		this.sortNum = sortNum;
	}
	public int getCharmLevel() {
		return charmLevel;
	}
	public void setCharmLevel(int charmLevel) {
		this.charmLevel = charmLevel;
	}
	public String getRoomRoles() {
		return roomRoles;
	}
	public void setRoomRoles(String roomRoles) {
		this.roomRoles = roomRoles;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public int getGuidH(){
		return GuidUtil.getGuidhAndGuidl(guid)[0];
	}
	
	public int getGuidL(){
		return GuidUtil.getGuidhAndGuidl(guid)[1];
	}
	
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
				+ caifuLevel + ", icon=" + icon + ", isMaster=" + master
				+ ", masterLevel=" + masterLevel + ", charmLevel=" + charmLevel
				+ ", userName=" + userName + ", roleId=" + roleId
				+ ", userType=" + userType + ", zoneName=" + zoneName
				+ ", fensiLevel=" + fensiLevel + ", roomRoles=" + roomRoles
				+ ", extraInfo=" + extraInfo + "]";
	}
	
}
