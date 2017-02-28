package com.bochatclient.bean;

public class DisplaySUserBean {
	private int fensiLevel = 0;   // 粉丝等级
	private int caifuLevel = 0;   // 财富等级
	
	public DisplaySUserBean(int fensi, int caifu) {
		this.fensiLevel = fensi;
		this.caifuLevel = caifu;
	}
	
	public int getFensiLevel() {
		return fensiLevel;
	}
	public int getCaifuLevel() {
		return caifuLevel;
	}
	
	

}
