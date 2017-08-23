package com.bochatclient.enter;

public class TalkBean implements SendBean{
	private String _method_ = "SendPubMsg";
	private String toMasterId = "";
	private String toMasterNick = "";
	private String ct = "";
	private String pub = "0";
	private String v="0";
	
	public TalkBean(String msg,int action,String toMasterId,String toMasterNick) {
		this.ct = msg;
		this.toMasterId = toMasterId;
		this.toMasterNick = toMasterNick;
		if(action==1){
			this.pub = "1";
			this._method_ = "SendPrvMsg";
		}else if(action==2){
			this.pub = "0";
			this._method_ = "SendPrvMsg";
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

	public String getV() {
		return v;
	}
	
}
