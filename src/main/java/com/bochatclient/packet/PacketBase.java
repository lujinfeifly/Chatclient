package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.bean.DisplaySUserBean;

public class PacketBase {
	
	protected String nickName;
	protected String msg;
	protected String userID;
	protected int retcode;
	
	protected DisplaySUserBean user;
	

	public int getRetcode() {
		return retcode;
	}
	
	public PacketBase(String json) {
		JSONObject job = new JSONObject(json);
		retcode = Integer.parseInt(job.getString("retcode"));
	}
	
	public boolean isMsg() {
		return false;
	}
	
	public String toDisplayMsg() {
		return nickName + ":" + msg;
	}
	
	/**
	 * Dispaly Msg
	 * @return [0] 
	 */
	public String[] toDisplayMsgPair() {
		return new String[]{nickName, msg};
	}

	public String getNickName() {
		return nickName;
	}

	public String getMsg() {
		return msg;
	}

	public String getUserID() {
		return userID;
	}

	public DisplaySUserBean getUser() {
		return user;
	}

}
