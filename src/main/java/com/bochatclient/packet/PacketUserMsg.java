package com.bochatclient.packet;


import org.json.JSONObject;

import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.enums.PacketTypeConstant;

public class PacketUserMsg extends PacketBase{
	private String msg;
	private ChatUserSimpleBean userBean;
	
	public PacketUserMsg(String json) {
		super();
		this.type = PacketTypeConstant.USER_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.getString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		String typeStr = msgjo.getString("b");
		msg = msgjo.getString("ct");
		
		String userID = msgjo.getJSONObject("e").getString("bb");
		String nickName = msgjo.getJSONObject("e").getString("p");
		int fensi = msgjo.getJSONObject("e").getInt("b3");
		int caifu = msgjo.getJSONObject("e").getInt("h");

		userBean = new ChatUserSimpleBean();
		userBean.setUserId(Integer.parseInt(userID));
		userBean.setUserName(nickName);
		userBean.setFensiLevel(fensi);
		userBean.setCaifuLevel(caifu);
		
		switch(Integer.parseInt(typeStr)) {
		case 0:  // 公开说
			break;
		case 1:   // 对某人说
			break;
		case 2:   // 悄悄对某人说
			break;
		}
	}

	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "PacketUserMsg [retcode=" + retcode + ", type=" + type + ", msg=" + msg + ", userBean=" + userBean +"]";
	}
	
}
