package com.bochatclient;

public class TalkBean {
	private String _method_ = "SendPubMsg";
	private String toMasterId = "";
	private String toMasterNick = "";
	private String ct = "";
	private String pub = "0";
	
	public TalkBean(String msg,int action,String toMasterId,String toMasterNick) {
		this.ct = msg;
		this.toMasterId = toMasterId;
		this.toMasterNick = toMasterNick;
		if(action>0){
			this.pub = "1";
		}
	}
}
