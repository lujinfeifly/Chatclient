package com.bochatclient.enter;

public class TalkBean implements SendBean{
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

	public String get_method_() {
		return _method_;
	}

	public String getToMasterId() {
		return toMasterId;
	}

	public String getToMasterNick() {
		return toMasterNick;
	}

	public String getCt() {
		return ct;
	}

	public String getPub() {
		return pub;
	}
	
}
