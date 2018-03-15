package com.bochatclient.bean;

import com.bochatclient.annotation.Mapping;

public class ChatPkMasterBean {
	
	@Mapping("b")
	private String icon;//主播头像
	@Mapping("a")
	private String nickName;//主播昵称+区服名
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "ChatPkMasterBean [icon=" + icon + ", nickName=" + nickName + "]";
	}
	
		
}
