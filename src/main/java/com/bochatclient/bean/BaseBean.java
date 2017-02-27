package com.bochatclient.bean;

import java.util.List;

public class BaseBean<T> {
	private String retcode;
	private String retmsg;
	private String escapeflag;
	private List<T> msg;
	private int v;
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	public String getEscapeflag() {
		return escapeflag;
	}
	public void setEscapeflag(String escapeflag) {
		this.escapeflag = escapeflag;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public List<T> getMsg() {
		return msg;
	}
	public void setMsg(List<T> msg) {
		this.msg = msg;
	}
}
