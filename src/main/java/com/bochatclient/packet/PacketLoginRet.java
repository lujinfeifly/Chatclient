package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.ExtraInfoBean;
import com.bochatclient.enums.PacketConstant;


public class PacketLoginRet extends PacketBase {
	private ChatUserSimpleBean userBean;
	
	public PacketLoginRet(String json) {
		super();
		
		this.type=PacketConstant.PacketType.LOGIN_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		if(retcode!=0){//登陆异常，后面不解析
			return;
		}
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		JSONObject ujob = msgjo.optJSONObject("ct");
		if(ujob!=null){
			int userId = ujob.optInt("bb");
			int caifu = ujob.optInt("h");
			String icon = ujob.optString("j");
			boolean isMaster = ujob.optBoolean("l");
			int masterLevel = ujob.optInt("o");
			String userName = ujob.optString("p");
//			String roleId = ujob.optString("y");
			String zoneName = ujob.optString("b1");
			int fensiLevel = ujob.optInt("b3");
			
			userBean = new ChatUserSimpleBean();
			userBean.setUserId(userId);
			userBean.setCaifuLevel(caifu);
			userBean.setIcon(icon);
			userBean.setMaster(isMaster);
			userBean.setMasterLevel(masterLevel);
			userBean.setUserName(userName);
//			userBean.setRoleId(roleId);
			userBean.setZoneName(zoneName);
			userBean.setFensiLevel(fensiLevel);
			
			JSONObject enterJob = new JSONObject(ujob.optString("g"));
			if(enterJob!=null){
				String path = enterJob.optString("b7");
				String effect = enterJob.optString("b9");
				boolean needBroadCast = enterJob.optBoolean("c2");
				
				ExtraInfoBean enb = new ExtraInfoBean();
				enb.setEnterEffectPath(path);
				enb.setEnterEffect(effect);
				enb.setNeedBroadCast(needBroadCast);
				userBean.setExtraInfo(enb);
			}
		}
	}

	@Override
	public String toString() {
		return "PacketLoginRet [retcode=" + retcode + ", type=" + type + "]";
	}

	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}
	
}
