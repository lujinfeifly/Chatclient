package com.bochatclient.enter;

public class UserEnterBean implements SendBean{
	
	private String _method_ = "Enter";
	private int type = 0;
	private String rid;
	private String uid;
	private String uname;
	private String token;
	private String majorType = "0";
	private String md5 = "RTYUI";
	private String terminal="2";
	private String isReConnect="0";
	private String v="0";
	
	public UserEnterBean(String uid, String token, String rid, String uname) {
		this.uid = uid;
		this.token = token;
		this.rid = rid;
		this.uname = uname;
	}
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMajorType() {
		return majorType;
	}
	public void setMajorType(String majorType) {
		this.majorType = majorType;
	}
	public String get_method_() {
		return _method_;
	}
	public int getType() {
		return type;
	}
	public String getMd5() {
		return md5;
	}
	public String getTerminal() {
		return terminal;
	}
	public String getIsReConnect() {
		return isReConnect;
	}
	public void setIsReConnect(String isReConnect) {
		this.isReConnect = isReConnect;
	}
	public String getV() {
		return v;
	}

	@Override
	public String toString() {
		return "UserEnterBean [_method_=" + _method_ + ", type=" + type
				+ ", rid=" + rid + ", uid=" + uid + ", uname=" + uname
				+ ", token=" + token + ", majorType=" + majorType + ", md5="
				+ md5 + ", terminal=" + terminal + ", isReConnect="
				+ isReConnect + ", v=" + v + "]";
	}

}
