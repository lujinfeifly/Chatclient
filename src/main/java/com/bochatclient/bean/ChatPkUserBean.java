package com.bochatclient.bean;

import com.bochatclient.annotation.Mapping;

public class ChatPkUserBean {
	
	@Mapping("a")
	private int type;//类型：1-贡献最高/2-一血/3-神补刀
	@Mapping("b")
	private int icon;//用户头像id
	@Mapping("c")
	private String nickName;//用户昵称
	@Mapping("d")
	private long value;//贡献值
	@Mapping("e")
	private int caifuLevel;//财富等级
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public int getCaifuLevel() {
		return caifuLevel;
	}
	public void setCaifuLevel(int caifuLevel) {
		this.caifuLevel = caifuLevel;
	}
	@Override
	public String toString() {
		return "ChatPkUserBean [type=" + type + ", icon=" + icon + ", nickName=" + nickName + ", value=" + value
				+ ", caifuLevel=" + caifuLevel + "]";
	}
		
}
