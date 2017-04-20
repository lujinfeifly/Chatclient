package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketBannedInfo.java
 * @Description: 广播消息
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketHeadline extends PacketBase{

	
	@Mapping("a")
	private int charmLevel;//魅力等级
	@Mapping("b")
	private boolean comboAutoSwitch;//连击开关
	@Mapping("c")
	private int comboGroupNum;//连击组数
	@Mapping("d")
	private int fensiLevel;//粉丝等级
	@Mapping("f")
	private int giftCount;//礼物数量
	@Mapping("h")
	private long giftId;//礼物id
	@Mapping("i")
	private String giftName;//礼物名称
	@Mapping("j")
	private long roomId;//房间号
	@Mapping("k")
	private String roomName;//房间名称
	@Mapping("l")
	private String time;//发送时间
	@Mapping("m")
	private int vipLevel;//vip等级
	@Mapping("n")
	private int masterLevel;//主播等级
	@Mapping("o")
	private String rcvUserName;//接收人名称
//	@Mapping("r")
//	private String roomUrl;//房间地址
	@Mapping("s")
	private int sentCaifuLevel;//送礼人财富等级
	@Mapping("t")
	private String sentUserName;//送礼人名称
	@Mapping("v")
	private int qingsheng;//情圣徽章
	
	
	public int getCharmLevel() {
		return charmLevel;
	}
	public void setCharmLevel(int charmLevel) {
		this.charmLevel = charmLevel;
	}
	public boolean isComboAutoSwitch() {
		return comboAutoSwitch;
	}
	public void setComboAutoSwitch(boolean comboAutoSwitch) {
		this.comboAutoSwitch = comboAutoSwitch;
	}
	public int getComboGroupNum() {
		return comboGroupNum;
	}
	public void setComboGroupNum(int comboGroupNum) {
		this.comboGroupNum = comboGroupNum;
	}
	public int getFensiLevel() {
		return fensiLevel;
	}
	public void setFensiLevel(int fensiLevel) {
		this.fensiLevel = fensiLevel;
	}
	public int getGiftCount() {
		return giftCount;
	}
	public void setGiftCount(int giftCount) {
		this.giftCount = giftCount;
	}
	public long getGiftId() {
		return giftId;
	}
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public int getMasterLevel() {
		return masterLevel;
	}
	public void setMasterLevel(int masterLevel) {
		this.masterLevel = masterLevel;
	}
	public String getRcvUserName() {
		return rcvUserName;
	}
	public void setRcvUserName(String rcvUserName) {
		this.rcvUserName = rcvUserName;
	}
//	public String getRoomUrl() {
//		return roomUrl;
//	}
//	public void setRoomUrl(String roomUrl) {
//		this.roomUrl = roomUrl;
//	}
	public int getSentCaifuLevel() {
		return sentCaifuLevel;
	}
	public void setSentCaifuLevel(int sentCaifuLevel) {
		this.sentCaifuLevel = sentCaifuLevel;
	}
	public String getSentUserName() {
		return sentUserName;
	}
	public void setSentUserName(String sentUserName) {
		this.sentUserName = sentUserName;
	}
	public int getQingsheng() {
		return qingsheng;
	}
	public void setQingsheng(int qingsheng) {
		this.qingsheng = qingsheng;
	}
	@Override
	public String toString() {
		return "PacketHeadline [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", charmLevel="
				+ charmLevel + ", comboAutoSwitch=" + comboAutoSwitch
				+ ", comboGroupNum=" + comboGroupNum + ", fensiLevel="
				+ fensiLevel + ", giftCount=" + giftCount + ", giftId="
				+ giftId + ", giftName=" + giftName + ", roomId=" + roomId
				+ ", roomName=" + roomName + ", time=" + time + ", vipLevel="
				+ vipLevel + ", masterLevel=" + masterLevel + ", rcvUserName="
				+ rcvUserName + ", sentCaifuLevel=" + sentCaifuLevel
				+ ", sentUserName=" + sentUserName + ", qingsheng=" + qingsheng
				+ "]";
	}
	
}
