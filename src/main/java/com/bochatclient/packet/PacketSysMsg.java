package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.enums.PacketTypeConstant;

public class PacketSysMsg extends PacketBase{
	
	private String msg;
	private String sender;
	
	public PacketSysMsg(String json) {
		
		super();
		this.type = PacketTypeConstant.SYS_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.getString("retcode"));
		
		sender = "系统消息";
		
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = job.getString("escapeflag");
		
		String ct = msgjo.getString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);

			
			JSONObject jobct = new JSONObject(jsonct);
			msg = jobct.getString("mes");
		}
	}

	public String getSender() {
		return sender;
	}

	public String getMsg() {
		return msg;
	}
	
}
