package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.GiftBean;

public class PacketGiftMsg extends PacketBase {
	@Mapping("n")
	private long giftId;
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
	
	//---用户信息----
	@Mapping("b2")
	private int userId;
	@Mapping("b9")
	private String userName;
	@Mapping("e")
	private int fensiLevel;
	@Mapping("b7")
	private int caifuLevel;
	@Mapping("c2")
	private int userType;
	
	
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

	public void setGiftBean(GiftBean giftBean) {
		this.giftBean = giftBean;
	}
	
	public ChatUserSimpleBean getUserBean() {
		userBean=new ChatUserSimpleBean();
		userBean.setUserId(userId);
		userBean.setUserName(userName);
		userBean.setFensiLevel(fensiLevel);
		userBean.setCaifuLevel(caifuLevel);
		userBean.setUserType(userType);
		return userBean;
	}

	public GiftBean getGiftBean() {
		giftBean=new GiftBean();
		giftBean.setIsFree(isFree);
		giftBean.setGiftId(giftId);
		giftBean.setGiftName(giftName);
		giftBean.setGiftCount(giftCount);
		giftBean.setComboAutoSwitch(comboAutoSwitch);
		giftBean.setComboFlag(comboFlag);
		giftBean.setComboGroupNum(comboGroupNum);
		giftBean.setComboNum(comboNum);
		giftBean.setGiftIcon(giftIcon);
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
