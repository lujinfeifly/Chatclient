package com.bochatclient.packet;

import java.util.List;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.bean.BaseBean;

public class PacketSysMsg extends PacketBase{
	
	@Override
	public boolean isMsg() {
		return true;
	}

	public PacketSysMsg(String json) {
		
		super(json);
		JSONObject job = new JSONObject(json);
		nickName = "系统消息";
		
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
}
