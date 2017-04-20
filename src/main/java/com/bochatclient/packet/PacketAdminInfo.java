package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketBannedInfo.java
 * @Description: 设置|取消管理员
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketAdminInfo extends PacketBase{
	
	@Mapping("h")
	private int action;//PacketBannedInfo包中 （0-踢人/1-禁言/2-解禁） PacketAdminInfo包中（1-设置/2-取消）
	@Mapping(value="f",type="object")
	private ChatUserSimpleBean achatUser;//操作人
	@Mapping(value="b",type="object")
	private ChatUserSimpleBean bchatUser;//被操作人
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
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
		return "PacketAdminInfo [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", action="
				+ action + ", achatUser=" + achatUser + ", bchatUser="
				+ bchatUser + "]";
	}
}
