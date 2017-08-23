package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketLiveStart.java
 * @Description: 房间开播
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketLiveStart extends PacketBase{
	
	@Mapping("a")
	private int cdnType;//cdn类型
	@Mapping("d")
	private int hd;//是否高清(0-普通的FLASH/3-高清助手)
	@Mapping("e")
	private int isHide;//是否隐藏开播消息(0-不隐藏/1-隐藏)
	@Mapping("f")
	private int isMute;//是否静音
	@Mapping("g")
	private int liveId;//直播id
	@Mapping("h")
	private int liveType;//直播类型(0-普通/1-收费/2-密码)
	@Mapping("bb")
	private int masterId;//masterId 主播用户的ID
	@Mapping("j")
	private String liveTime;//开播时间
	@Mapping("m")
	private String masterName;//masterName 主播名称
	
	@Mapping("n")
	private int roomType;     // roomType  房间类型（0-个人/1-三麦）
	@Mapping("o")
	private int showType; // showType 直播类型(0-娱乐/1-游戏)
	
	@Mapping("p")
	private String streamName;//流名
	@Mapping("q")
	private int terminal;//terminal  开播设备（0-FLASH/1-助手）
	
	@Mapping("s")
	private String streamUrl;//流名
//	@Mapping(value="t",type="object")
	private ChatUserSimpleBean chatUser;//主播信息
	@Mapping("u")
	private int way;// way  开播方式(0-普通/1-续播)
	
	public int getCdnType() {
		return cdnType;
	}
	public void setCdnType(int cdnType) {
		this.cdnType = cdnType;
	}
	public int getHd() {
		return hd;
	}
	public void setHd(int hd) {
		this.hd = hd;
	}
	public int getIsHide() {
		return isHide;
	}
	public void setIsHide(int isHide) {
		this.isHide = isHide;
	}
	public int getIsMute() {
		return isMute;
	}
	public void setIsMute(int isMute) {
		this.isMute = isMute;
	}
	public int getLiveId() {
		return liveId;
	}
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
	public int getLiveType() {
		return liveType;
	}
	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getLiveTime() {
		return liveTime;
	}
	public void setLiveTime(String liveTime) {
		this.liveTime = liveTime;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public int getShowType() {
		return showType;
	}
	public void setShowType(int showType) {
		this.showType = showType;
	}
	public String getStreamName() {
		return streamName;
	}
	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}
	public int getTerminal() {
		return terminal;
	}
	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}
	public String getStreamUrl() {
		return streamUrl;
	}
	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}
	public int getWay() {
		return way;
	}
	public void setWay(int way) {
		this.way = way;
	}
	public ChatUserSimpleBean getChatUser() {
		return chatUser;
	}
	public void setChatUser(ChatUserSimpleBean chatUser) {
		this.chatUser = chatUser;
	}
	@Override
	public String toString() {
		return "PacketLiveStart [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", cdnType="
				+ cdnType + ", hd=" + hd + ", isHide=" + isHide + ", isMute="
				+ isMute + ", liveId=" + liveId + ", liveType=" + liveType
				+ ", masterId=" + masterId + ", liveTime=" + liveTime
				+ ", masterName=" + masterName + ", roomType=" + roomType
				+ ", showType=" + showType + ", streamName=" + streamName
				+ ", terminal=" + terminal + ", streamUrl=" + streamUrl
				+ ", way=" + way + "]";
	}
}
