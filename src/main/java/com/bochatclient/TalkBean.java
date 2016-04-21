package com.bochatclient;

public class TalkBean {
	private String _method_ = "SendPubMsg";
	private String toMasterId = "";
	private String toMasterNick = "";
	private String ct = "";
	
	public TalkBean(String msg) {
		ct = msg;
	}
}
