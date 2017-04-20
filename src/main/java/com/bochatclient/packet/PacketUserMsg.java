package com.bochatclient.packet;


import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketUserMsg.java
 * @Description: 房间聊天消息
 * @author renms
 * @date 2017年4月7日 下午2:25:15 
 * @version 1.0
 */
public class PacketUserMsg extends PacketBase{
	@Mapping("ct")
	private String msg;
	
	@Mapping(value="e",type="object")
	private ChatUserSimpleBean achatUser;//操作人
	@Mapping(value="f",type="object")
	private ChatUserSimpleBean bchatUser;//被操作人
	@Mapping("b")
	private String msgType;//0-对大家说/1-公开对某人说/2-悄悄对某人说 (113 114 115)-飞屏消息
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ChatUserSimpleBean getAchatUser() {
		return achatUser;
	}
	public void setAchatUser(ChatUserSimpleBean achatUser) {
		this.achatUser = achatUser;
	}
	public ChatUserSimpleBean getBchatUser() {
		return bchatUser;
	}
	public void setBchatUser(ChatUserSimpleBean bchatUser) {
		this.bchatUser = bchatUser;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	@Override
	public String toString() {
		return "PacketUserMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", msg=" + msg
				+ ", achatUser=" + achatUser + ", bchatUser=" + bchatUser
				+ ", msgType=" + msgType + "]";
	}
}
