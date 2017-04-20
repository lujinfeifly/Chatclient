package com.bochatclient.enter;

/**
 * 查询用户信息
 * @author lujinfei
 *
 */
public class UserMsgBean implements SendBean{
//	private String rid;
//	private String uid;
	private String bb;
	private String v = "0";
	
	public UserMsgBean(String rid, String uid, String bb) {
//		this.rid = rid;
//		this.uid = uid;
		this.bb = bb;
	}

	public String getBb() {
		return bb;
	}

	public String getV() {
		return v;
	}

	
}
