package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

public class PacketAudioStateMsg extends PacketBase {
	
	@Mapping("a")
	private int status;	//开关状态，0-开麦/1-关麦
	@Mapping("bb")
	private int userId; //用户id
	@Mapping("c")
	private String userName;//用户昵称
	@Mapping("d")
	private long userNo; //操作人靓号
	@Mapping("f")
	private int masterId; //主播的的uid
	@Mapping("g")
	private String masterName;//主播昵称
	@Mapping("h")
	private long masterNo;//主播靓号
	
	private ChatUserSimpleBean chatUser;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public long getMasterNo() {
		return masterNo;
	}
	public void setMasterNo(long masterNo) {
		this.masterNo = masterNo;
	}
	public ChatUserSimpleBean getChatUser() {
		return chatUser;
	}
	public void setChatUser(ChatUserSimpleBean chatUser) {
		this.chatUser = chatUser;
	}
	@Override
	public String toString() {
		return "PacketOperRoomState [status=" + status + ", userId=" + userId + ", userName=" + userName + ", userNo="
				+ userNo + ", masterId=" + masterId + ", masterName=" + masterName + ", masterNo=" + masterNo + "]";
	}
}
