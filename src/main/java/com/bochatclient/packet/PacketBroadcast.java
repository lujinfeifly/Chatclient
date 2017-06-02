package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketBannedInfo.java
 * @Description: 广播消息
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketBroadcast extends PacketBase{
	

	@Mapping("bb")
	private int userId;//用户id
	@Mapping("f")
	private String userName;//用户名称
	@Mapping("b")
	private String content;//消息内容
	@Mapping("c")
	private long roomId;//房间号
	@Mapping("d")
	private String time;//发送时间
//	@Mapping("e")
//	private String roomUrl;//房间地址
	@Mapping("h")
	private String masterName;//主播名称
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	//	public String getRoomUrl() {
//		return roomUrl;
//	}
//	public void setRoomUrl(String roomUrl) {
//		this.roomUrl = roomUrl;
//	}
	@Override
	public String toString() {
		return "PacketBroadcast [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", userId="
				+ userId + ", userName=" + userName + ", content=" + content
				+ ", roomId=" + roomId + ", time=" + time + ",masterName="+masterName+"]";
	}
}
