package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.enums.PacketConstant;


public class PacketLogoutRet extends PacketBase {
	private String userId;
	
	public PacketLogoutRet(String json) {
		super();
		
		this.type=PacketConstant.PacketType.LOGOUT_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		userId = msgjo.optString("ct");
	}

	@Override
	public String toString() {
		return "PacketLogoutRet [retcode=" + retcode + ", type=" + type + "]";
	}

	public String getUserId() {
		return userId;
	}
}
