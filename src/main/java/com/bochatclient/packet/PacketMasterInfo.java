package com.bochatclient.packet;


import org.json.JSONObject;

import com.bochatclient.bean.ChatUserBean;
import com.bochatclient.enums.PacketConstant;

public class PacketMasterInfo extends PacketBase{
	private ChatUserBean ChatUser;
	
	public PacketMasterInfo(String json) {
		super();
		this.type = PacketConstant.PacketType.USER_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		JSONObject ctjob = msgjo.optJSONObject("ct");
		
	}
}
