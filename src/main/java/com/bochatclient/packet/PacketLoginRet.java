package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;


public class PacketLoginRet extends PacketBase {
	
	@Mapping(value="ct",type="object")
	private ChatUserSimpleBean userBean;

	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}

	public void setUserBean(ChatUserSimpleBean userBean) {
		this.userBean = userBean;
	}

	@Override
	public String toString() {
		return "PacketLoginRet [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", userBean="
				+ userBean.toString() + "]";
	}
}
