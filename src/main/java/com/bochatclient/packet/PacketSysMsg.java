package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.enums.PacketConstant;

public class PacketSysMsg extends PacketBase{
	
	private String msg;
	private String sender;
	
	public PacketSysMsg(String json) {
		
		super();
		this.type = PacketConstant.PacketType.SYS_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		sender = "系统消息";
		
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		String typeStr = job.optString("escapeflag");
		
		String ct = msgjo.optString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);
			JSONObject jobct = new JSONObject(jsonct);
			msg = jobct.optString("mes");
		}
	}

	public String getSender() {
		return sender;
	}

	public String getMsg() {
		return msg;
	}
	
}
