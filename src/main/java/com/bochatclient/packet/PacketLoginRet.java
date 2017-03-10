package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.ExtraInfoBean;
import com.bochatclient.enums.PacketTypeConstant;


public class PacketLoginRet extends PacketBase {
	private ChatUserSimpleBean userBean;
	
	public PacketLoginRet(String json) {
		super();
		
		this.type=PacketTypeConstant.LOGIN_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.getString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		JSONObject ujob = msgjo.getJSONObject("ct");
		if(ujob!=null){
			int userId = ujob.getInt("bb");
			int caifu = ujob.getInt("h");
			String icon = ujob.getString("j");
			boolean isMaster = ujob.getBoolean("l");
			int masterLevel = ujob.getInt("o");
			String userName = ujob.getString("p");
//			String roleId = ujob.getString("y");
			String zoneName = ujob.getString("b1");
			int fensiLevel = ujob.getInt("b3");
			
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
			
			JSONObject enterJob = ujob.getJSONObject("g");
			if(enterJob!=null){
				String path = enterJob.getString("b7");
				String effect = enterJob.getString("b9");
				boolean needBroadCast = enterJob.getBoolean("c2");
				
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
