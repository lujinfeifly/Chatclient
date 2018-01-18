package com.bochatclient.packet;



public class PacketBase {
	
	protected int retcode;
	protected String retmsg;
	protected int type;//packet包类型
	protected int version;
	protected Object extend;
	
	public int getRetcode() {
		return retcode;
	}
	public int getType() {
		return type;
	}
	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Object getExtend() {
		return extend;
	}
	public void setExtend(Object extend) {
		this.extend = extend;
	}
}
