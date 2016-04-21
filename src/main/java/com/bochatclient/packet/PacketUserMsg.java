package com.bochatclient.packet;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PacketUserMsg extends PacketBase{
	
	
	
	public PacketUserMsg(String json) { 
		super(json);
		JSONObject job = JSONObject.fromObject(json);
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = msgjo.getString("msgtype");
		
		int type = Integer.parseInt(typeStr);
		switch (type) {
		case 0:
			nickName = msgjo.getString("masterNick");
			msg = "欢迎进入";
			break;
		case 2:
			nickName = msgjo.getString("masterNick");
			msg = msgjo.getString("ct");
			break;
		}
	}
	
	@Override
	public boolean isMsg() {
		return true;
	}
}
