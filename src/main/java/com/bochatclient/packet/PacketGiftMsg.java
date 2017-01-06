package com.bochatclient.packet;

import com.bochatclient.URLEncode;

import net.sf.json.JSONObject;

public class PacketGiftMsg extends PacketBase {
	@Override
	public boolean isMsg() {
		return true;
	}

	public PacketGiftMsg(String json) {
		super(json);
		JSONObject job = JSONObject.fromObject(json);
		
		// 礼物中只会出现get(0),也就是只有一个元素
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = job.getString("escapeflag");
		
		String ct = msgjo.getString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);
			
			System.out.println(jsonct);

			JSONObject jobct = JSONObject.fromObject(jsonct);
			// 发送人id
			userID = jobct.getString("bb");
			nickName = jobct.getString("b9");
			msg = "我送了" + jobct.getString("q");
		}
	}
}
