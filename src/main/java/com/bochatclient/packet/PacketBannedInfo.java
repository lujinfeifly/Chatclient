package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketBannedInfo.java
 * @Description: 禁言|解禁包|踢人
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketBannedInfo extends PacketBase{
	
	@Mapping("b")
	private int action;//PacketBannedInfo包中 （0-踢人/1-禁言/2-解禁） PacketAdminInfo包中（1-设置/2-取消）
	@Mapping("ct")
	private String bannedTime;//禁言时间
	@Mapping("c")
	private String msgType;
	@Mapping("d")
	private String msgTime;//消息时间
	@Mapping(value="e",type="object")
	private ChatUserSimpleBean achatUser;//操作人
	@Mapping(value="f",type="object")
	private ChatUserSimpleBean bchatUser;//被操作人
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getBannedTime() {
		return bannedTime;
	}
	public void setBannedTime(String bannedTime) {
		this.bannedTime = bannedTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
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
	@Override
	public String toString() {
		return "PacketBannedInfo [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", action="
				+ action + ", bannedTime=" + bannedTime + ", msgType="
				+ msgType + ", msgTime=" + msgTime + ", achatUser=" + achatUser
				+ ", bchatUser=" + bchatUser + "]";
	}
}
