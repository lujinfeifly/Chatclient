package com.bochatclient.packet;

import java.util.List;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ComboBean;

public class PacketGiftComboMsg extends PacketBase {

	
	@Mapping(value="ct",type="list",name="com.bochatclient.bean.ComboBean")
	private List<ComboBean> comboList;
	public List<ComboBean> getComboList() {
		return comboList;
	}
	public void setComboList(List<ComboBean> comboList) {
		this.comboList = comboList;
	}
//
//	@Mapping("a")
//	private boolean comboAutoSwitch;//连击开关
//	@Mapping("b")
//	private int comboGroupNum;//连击组数
//	@Mapping("bb")
//	private int userId;
//	@Mapping("i")
//	private String userName;
//	@Mapping("c")
//	private int comboUuid;//combo 唯一标识
//	@Mapping("d")
//	private int giftCount;//礼物数量
//	@Mapping("g")
//	private long giftId;
//	@Mapping("h")
//	private int giftPrice;//礼物单价
//	public boolean isComboAutoSwitch() {
//		return comboAutoSwitch;
//	}
//	public void setComboAutoSwitch(boolean comboAutoSwitch) {
//		this.comboAutoSwitch = comboAutoSwitch;
//	}
//	public int getComboGroupNum() {
//		return comboGroupNum;
//	}
//	public void setComboGroupNum(int comboGroupNum) {
//		this.comboGroupNum = comboGroupNum;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public int getComboUuid() {
//		return comboUuid;
//	}
//	public void setComboUuid(int comboUuid) {
//		this.comboUuid = comboUuid;
//	}
//	public int getGiftCount() {
//		return giftCount;
//	}
//	public void setGiftCount(int giftCount) {
//		this.giftCount = giftCount;
//	}
//	public long getGiftId() {
//		return giftId;
//	}
//	public void setGiftId(long giftId) {
//		this.giftId = giftId;
//	}
//	public int getGiftPrice() {
//		return giftPrice;
//	}
//	public void setGiftPrice(int giftPrice) {
//		this.giftPrice = giftPrice;
//	}
//	
//	@Override
//	public String toString() {
//		return "PacketGiftComboMsg [retcode=" + retcode + ", retmsg=" + retmsg
//				+ ", type=" + type + ", version=" + version
//				+ ", comboAutoSwitch=" + comboAutoSwitch + ", comboGroupNum="
//				+ comboGroupNum + ", userId=" + userId + ", userName="
//				+ userName + ", comboUuid=" + comboUuid + ", giftCount="
//				+ giftCount + ", giftId=" + giftId + ", giftPrice=" + giftPrice
//				+ "]";
//	}
	@Override
	public String toString() {
		return "PacketGiftComboMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", comboList="
				+ comboList + "]";
	}

	
}
