package com.bochatclient.packet;


import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserBean;

/**
 * @ClassName: PacketUserInfo.java
 * @Description: 用户信息
 * @author renms
 * @date 2017年4月7日 下午2:25:15 
 * @version 1.0
 */
public class PacketUserInfo extends PacketBase{
	@Mapping(value="ct",type="object")
	private ChatUserBean chatUser;//操作人

	public ChatUserBean getChatUser() {
		return chatUser;
	}
	public void setChatUser(ChatUserBean chatUser) {
		this.chatUser = chatUser;
	}
	@Override
	public String toString() {
		return "PacketUserInfo [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", chatUser="
				+ chatUser + "]";
	}
}
