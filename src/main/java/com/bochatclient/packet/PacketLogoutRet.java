package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketLogoutRet.java
 * @Description: 离开房间
 * @author renms
 * @date 2017年4月13日 下午1:43:02 
 * @version 1.0
 */
public class PacketLogoutRet extends PacketBase {
	
	@Mapping("ct")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PacketLogoutRet [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", userId="
				+ userId + "]";
	}
	
}
