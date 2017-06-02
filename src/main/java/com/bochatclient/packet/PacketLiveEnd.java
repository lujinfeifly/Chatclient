package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketLiveEnd.java
 * @Description: 关闭通知
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketLiveEnd extends PacketBase{
	
	
	@Mapping("a")
	private int closeType;
	@Mapping("b")
	private int code;
	@Mapping("c")
	private String endTime;
	@Mapping("d")
	private int hd;//是否高清(0-普通的FLASH/3-高清助手)
	@Mapping("e")
	private int isRefresh;//isRefresh  是否刷新页面(0-刷新/1-不刷新)
	@Mapping("f")
	private int masterId;
	@Mapping("g")
	private String nickName;//主播昵称
	@Mapping("h")
	private int roomType;//房间类型（0-个人/1-三麦）
	
	public int getCloseType() {
		return closeType;
	}

	public void setCloseType(int closeType) {
		this.closeType = closeType;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public int getIsRefresh() {
		return isRefresh;
	}

	public void setIsRefresh(int isRefresh) {
		this.isRefresh = isRefresh;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "PacketLiveEnd [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", closeType="
				+ closeType + ", code=" + code + ", endTime=" + endTime
				+ ", hd=" + hd + ", isRefresh=" + isRefresh + ", masterId="
				+ masterId + ", nickName=" + nickName + ", roomType="
				+ roomType + "]";
	}
}