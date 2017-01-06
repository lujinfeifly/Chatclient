package com.bochatclient.packet;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PacketUserMsg extends PacketBase{
	
	
	
	public PacketUserMsg(String json) { 
		super(json);
		JSONObject job = JSONObject.fromObject(json);
		
		
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = msgjo.getString("b");
		msg = msgjo.getString("ct");
		userID = msgjo.getJSONObject("e").getString("bb");
		nickName = msgjo.getJSONObject("e").getString("p");
		
		switch(Integer.parseInt(typeStr)) {
		case 0:  // 公开说
			break;
		case 1:   // 对某人说
			break;
		case 2:   // 悄悄对某人说
			break;
		}
		
	}
	
	@Override
	public boolean isMsg() {
		return true;
	}
}
