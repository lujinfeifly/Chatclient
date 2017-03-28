package com.bochatclient.packet;


import org.json.JSONObject;

import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.enums.PacketConstant;

public class PacketUserMsg extends PacketBase{
	private String msg;
	private ChatUserSimpleBean userBean;
	private String msgType;
	private ChatUserSimpleBean toUserBean;
	
	public PacketUserMsg(String json) {
		super();
		this.type = PacketConstant.PacketType.USER_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		msgType = msgjo.optString("b");//0-对大家说/1-公开对某人说/2-悄悄对某人说
		msg = msgjo.optString("ct");
		
		JSONObject ejob = msgjo.optJSONObject("e");
		
		String userID = ejob.optString("bb");
		String nickName = ejob.optString("p");
		int fensi = ejob.optInt("b3");
		int caifu = ejob.optInt("h");
		int userType = ejob.optInt("a8");
		String roomRole = ejob.optString("a1");

		userBean = new ChatUserSimpleBean();
		userBean.setUserId(Integer.parseInt(userID));
		userBean.setUserName(nickName);
		userBean.setFensiLevel(fensi);
		userBean.setCaifuLevel(caifu);
		userBean.setUserType(userType);
		userBean.setRoomRoles(roomRole.split(","));
		
		switch(Integer.parseInt(msgType)) {
		case 0:  // 公开说
			break;
		case 1:   // 对某人说
		case 2:   // 悄悄对某人说
			JSONObject tojob = msgjo.optJSONObject("f");
			if(tojob!=null){
				toUserBean = new ChatUserSimpleBean();
				toUserBean.setUserId(Integer.parseInt(tojob.optString("bb")));
				toUserBean.setUserName(tojob.optString("p"));
				toUserBean.setFensiLevel(tojob.optInt("b3"));
				toUserBean.setCaifuLevel(tojob.optInt("h"));
				toUserBean.setUserType(tojob.optInt("a8"));
				toUserBean.setRoomRoles(tojob.optString("a1").split(","));
			}
			break;
		}
	}

	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}
	
	public ChatUserSimpleBean getToUserBean() {
		return toUserBean;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "PacketUserMsg [retcode=" + retcode + ", type=" + type + ", msg=" + msg + ", userBean=" + userBean +"]";
	}
	
}
