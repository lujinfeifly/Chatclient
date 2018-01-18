package com.bochatclient.bean;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.utils.GuidUtil;


public class ChatUserBean {

//	"a":  “”,      //agent, 字段说明不详
//	"bb":   123,      //masterId 用户ID
//	"c":   “”,      //anchorUid 主播ID
//	"d":  12,      //charmLevel 魅力等级
//	"e":  12123,      //equipmentScore 装备历史最高评分
//	"f":  “”,      //expireSoon 背包内是否存在即将过期商品(json)
//	"g":  “”,      //extraInfo 进场动画
//	"h":  12,      //fanLevel 财富等级
//	"i":  0,      // hidden 是否隐身（0-不隐身/1-隐身）
//	"j":  “12”,      // icon 头像ID
//	"k":  “”,      // ip 用户登录IP
//	"l":  true,      // isAnchor 是否是主播	
//	"m":  0,      // isReConnect 是否断线重连
//	"o":  12,      // masterLevel 主播等级
//	"p":  12,      // masterNick 用户昵称
//	"q":  “null”,      // masterNo  用户靓号
//	"r":  “0”,      // masterNoFlag 靓号相关，目前无用
//	"s":  null,      // masterNoSwf 靓号的swf路径
//	"t":  12,      // menPai 门派ID
//	"u":  12,      // nextFanLevel 下一财富等级
//	"v":  5,      // nextFansLevel 下一粉丝等级
//	"w":  0,      // nextMasterLevel 下一主播等级
//	"x":  0,      // privateChat 是否允许私聊
//	"y":  12,      // roleId 角色ID
//	"z":  12,      // roleLevel 角色等级
//	"a1":  “1,3”,      // roomRole 房间角色
//	"a2":  1123002485,      // sortNum 排序
//	"a3":  12,      // teamId 战队ID
//	"a4":  “”,      // tlbbUid 角色GUID
//	"a5":  8,      // tlbbVip 角色天龙VIP
//	"a7":  “”,      //username 用户名
//	"a8":  50,      // userType 用户类型(5-假人/10-巡官/30-观众/40-管理员/50-主播)
//	"a9":  0,      // vipType VIP类型（目前无用）
//	"b1":  “”,      // zoneSeverName 大区名称
//	"b2":  50,      // fansExperience 粉丝经验
//	"b3":  2,      // fansLevel 粉丝等级
//	"b4":  “”,      // teamName 战队名称
//	"c3":  “”,      // terminal 端标识

	@Mapping("z")
	private int roleLevel;//角色等级
	@Mapping("x")
	private int privateChat;//是否允许私聊 
	@Mapping("e")
	private long equipmentScore;//装备评分
	@Mapping("t")
	private int menPaiId;
	
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
	public int getRoleLevel() {
		return roleLevel;
	}
	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}
	public int getPrivateChat() {
		return privateChat;
	}
	public void setPrivateChat(int privateChat) {
		this.privateChat = privateChat;
	}
	public long getEquipmentScore() {
		return equipmentScore;
	}
	public void setEquipmentScore(long equipmentScore) {
		this.equipmentScore = equipmentScore;
	}
	public int getMenPaiId() {
		return menPaiId;
	}
	public void setMenPaiId(int menPaiId) {
		this.menPaiId = menPaiId;
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
