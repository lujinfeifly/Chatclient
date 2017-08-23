package com.bochatclient.enter;

/**
 * 查询用户信息
 * @author renms
 *
 */
public class UserInfoBean implements SendBean{
	private String bb;
	private String v = "0";
	
	public UserInfoBean(String bb) {
		this.bb = bb;
	}

	public String getBb() {
		return bb;
	}

	public String getV() {
		return v;
	}

	
}
