package com.bochatclient.packet;

import java.util.List;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.DisplaySUserBean;

public class PacketGiftMsg extends PacketBase {
	@Override
	public boolean isMsg() {
		return true;
	}

	public PacketGiftMsg(String json) {
		
		super(json);
		JSONObject job = new JSONObject(json);
		
		// 礼物中只会出现get(0),也就是只有一个元素
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = job.getString("escapeflag");
		
		String ct = msgjo.getString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);			
			System.out.println(jsonct);

			JSONObject jobct = new JSONObject(jsonct);
			userID = jobct.getString("b2");
			nickName = jobct.getString("b9");
			int fensi = jobct.getInt("e");
			int caifu = jobct.getInt("b7");
			user = new DisplaySUserBean(fensi, caifu);
			msg = "我送了" + jobct.getString("q");
		}
	}
}
