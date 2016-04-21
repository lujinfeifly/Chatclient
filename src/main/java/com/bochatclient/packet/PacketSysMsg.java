package com.bochatclient.packet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.bochatclient.URLEncode;

import net.sf.json.JSONObject;

public class PacketSysMsg extends PacketBase{
	
	@Override
	public boolean isMsg() {
		return true;
	}

	public PacketSysMsg(String json) {
		super(json);
		JSONObject job = JSONObject.fromObject(json);
		nickName = "系统消息";
		
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = msgjo.getString("msgtype");
		
		String ct = msgjo.getString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);

			
			JSONObject jobct = JSONObject.fromObject(jsonct);
			msg = jobct.getString("mes");
		}
	}
}
