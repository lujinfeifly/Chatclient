package com.bochatclient.bean;

import com.bochatclient.annotation.Mapping;

public class ChatUserListBean implements Comparable<ChatUserListBean> {
	
	@Mapping("bb")
	private int userId;//用户id
	@Mapping("h")
	private int caifuLevel;//财富等级
	@Mapping("j")
	private String icon;//用户头像id
	@Mapping("a4")
	private String roleId;//角色id
	@Mapping("p")
	private String userName;//用户昵称
	@Mapping("b3")
	private int fensiLevel;//粉丝等级
	@Mapping("a2")
	private long sortNum;//粉丝等级
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCaifuLevel() {
		return caifuLevel;
	}
	public void setCaifuLevel(int caifuLevel) {
		this.caifuLevel = caifuLevel;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getFensiLevel() {
		return fensiLevel;
	}
	public void setFensiLevel(int fensiLevel) {
		this.fensiLevel = fensiLevel;
	}
	public long getSortNum() {
		return sortNum;
	}
	public void setSortNum(long sortNum) {
		this.sortNum = sortNum;
	}
	@Override
	public int compareTo(ChatUserListBean o) {
		return (int) (this.sortNum - o.getSortNum());
	}
}
