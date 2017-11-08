package com.bochatclient.enter;

/**
 * 查询用户信息
 * @author renms
 *
 */
public class UserInfoBean extends SendBean{
	private String bb;
	
	public UserInfoBean(String bb) {
		this.bb = bb;
	}

	public String getBb() {
		return bb;
	}
	
}
