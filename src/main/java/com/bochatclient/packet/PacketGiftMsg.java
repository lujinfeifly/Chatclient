package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.GiftBean;

public class PacketGiftMsg extends PacketBase {
	@Mapping("n")
	private long giftId;
	@Mapping("w")
	private String giftUId;
	@Mapping("a")
	private boolean comboAutoSwitch;//连击开关
	@Mapping("b")
	private int comboGroupNum;//连击组数
	@Mapping("c")
	private int comboNum;//连击次数
	@Mapping("i")
	private int giftCount;//礼物数量
	@Mapping("q")
	private String giftName;//礼物名称
	@Mapping("x")
	private boolean comboFlag;//是否连击
	@Mapping("y")
	private int isFree;//是否免费礼物 0-不是/1-是
	@Mapping("m")
	private String giftIcon;//礼物图片
	@Mapping("c6")
	private int version;//版本号
	@Mapping("c1")
	private String guid;//角色guid
	//---用户信息----
	@Mapping("bb")
	private int userId;
	@Mapping("b9")
	private String userName;
	@Mapping("e")
	private int fensiLevel;
	@Mapping("b7")
	private int caifuLevel;
	@Mapping("c2")
	private int userType;
	@Mapping("c7")
	private long giftTime;
	@Mapping("c8")
	private long roleId;//送礼人roleId
	private ChatUserSimpleBean userBean;
	private GiftBean giftBean;
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}

	public void setComboAutoSwitch(boolean comboAutoSwitch) {
		this.comboAutoSwitch = comboAutoSwitch;
	}

	public void setComboGroupNum(int comboGroupNum) {
		this.comboGroupNum = comboGroupNum;
	}

	public void setComboNum(int comboNum) {
		this.comboNum = comboNum;
	}

	public void setGiftCount(int giftCount) {
		this.giftCount = giftCount;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public void setComboFlag(boolean comboFlag) {
		this.comboFlag = comboFlag;
	}

	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	
	public void setGiftTime(long giftTime) {
		this.giftTime = giftTime;
	}

	public void setGiftIcon(String giftIcon) {
		this.giftIcon = giftIcon;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFensiLevel(int fensiLevel) {
		this.fensiLevel = fensiLevel;
	}

	public void setCaifuLevel(int caifuLevel) {
		this.caifuLevel = caifuLevel;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public void setUserBean(ChatUserSimpleBean userBean) {
		this.userBean = userBean;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public void setGiftBean(GiftBean giftBean) {
		this.giftBean = giftBean;
	}

	public void setGiftUId(String giftUId) {
		this.giftUId = giftUId;
	}

	public ChatUserSimpleBean getUserBean() {
		if(userBean==null){
			userBean = new ChatUserSimpleBean();
			userBean.setUserId(userId);
			userBean.setUserName(userName);
			userBean.setFensiLevel(fensiLevel);
			userBean.setCaifuLevel(caifuLevel);
			userBean.setUserType(userType);
			userBean.setGuid(guid);
			userBean.setRoleId(roleId);
		}
		return userBean;
	}

	public GiftBean getGiftBean() {
		if(giftBean==null){
			giftBean = new GiftBean();
			giftBean.setGiftUid(giftUId);
			giftBean.setIsFree(isFree);
			giftBean.setGiftId(giftId);
			giftBean.setGiftName(giftName);
			giftBean.setGiftCount(giftCount);
			giftBean.setGiftTime(giftTime);
			giftBean.setComboAutoSwitch(comboAutoSwitch);
			giftBean.setComboFlag(comboFlag);
			giftBean.setComboGroupNum(comboGroupNum);
			giftBean.setComboNum(comboNum);
			giftBean.setGiftIcon(giftIcon);
			giftBean.setVersion(version);
		}
		return giftBean;
	}

	public String getMsg() {
		String msg = " 送"+giftCount+"个 "+giftName;
		if(comboFlag){
			msg = " 送"+giftCount+"个 x "+comboGroupNum+"组 "+ giftName;
		}
		return msg;
	}

	@Override
	public String toString() {
		return "PacketGiftMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", giftId="
				+ giftId + ", comboAutoSwitch=" + comboAutoSwitch
				+ ", comboGroupNum=" + comboGroupNum + ", comboNum=" + comboNum
				+ ", giftCount=" + giftCount + ", giftName=" + giftName
				+ ", isComboFlag=" + comboFlag + ", isFree=" + isFree
				+ ", giftIcon=" + giftIcon + ", userId=" + userId
				+ ", userName=" + userName + ", fensiLevel=" + fensiLevel
				+ ", caifuLevel=" + caifuLevel + ", userType=" + userType + "]";
	}
}
