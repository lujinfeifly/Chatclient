package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.enums.PacketTypeConstant;

public class PacketGiftMsg extends PacketBase {
	protected String msg;
	private ChatUserSimpleBean userBean;
	
	public PacketGiftMsg(String json) {
		super();
		this.type=PacketTypeConstant.GIFT_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.getString("retcode"));
		
		// 礼物中只会出现get(0),也就是只有一个元素
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = job.getString("escapeflag");
		
		String ct = msgjo.getString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);			
			System.out.println(jsonct);
			userBean = new ChatUserSimpleBean();
			JSONObject jobct = new JSONObject(jsonct);
			userBean.setUserId(Integer.parseInt(jobct.getString("b2")));
			userBean.setUserName(jobct.getString("b9"));
			int fensi = jobct.getInt("e");
			int caifu = jobct.getInt("b7");
			userBean.setFensiLevel(fensi);
			userBean.setCaifuLevel(caifu);
			msg = "我送了" + jobct.getString("q");
		}
	}

	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}

	public String getMsg() {
		return msg;
	}
	
}
