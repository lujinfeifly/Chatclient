package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketChatInfo.java
 * @Description: 关闭|开启公聊
 * @author renms
 * @date 2017年4月7日 下午2:24:41 
 * @version 1.0
 */
public class PacketChatInfo extends PacketBase{
	
	@Mapping("flag")
	private int flag;
	@Mapping("roomId")
	private long roomId;
	@Mapping("userId")
	private long userId;
	@Mapping("userName")
	private String userName;
	
	private ChatUserSimpleBean chatUser;
	
	public int getFlag() {
		return flag;
	}
	public long getRoomId() {
		return roomId;
	}
	public long getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ChatUserSimpleBean getChatUser() {
		return chatUser;
	}
	public void setChatUser(ChatUserSimpleBean chatUser) {
		this.chatUser = chatUser;
	}
	@Override
	public String toString() {
		return "PacketChatInfo [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", flag=" + flag
				+ ", roomId=" + roomId + ", userId=" + userId + ", userName="
				+ userName + "]";
	}
}
