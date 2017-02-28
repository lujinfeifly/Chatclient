package com.bochatclient.packet;


import java.util.List;

import org.json.JSONObject;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.UserMsgBean;
import com.bochatclient.bean.UserMsgBeanCT;

public class PacketUserMsg extends PacketBase{
	
	
	
	public PacketUserMsg(String json) {
		super(json);
		JSONObject job = new JSONObject(json);
		
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
