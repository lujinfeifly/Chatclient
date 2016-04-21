package com.bochatclient.packet;

import net.sf.json.JSONObject;

public class PacketBase {
	
	protected String nickName;
	protected String msg;
	protected String userID;
	
	protected int retcode;
	
	
	
	public int getRetcode() {
		return retcode;
	}

	public PacketBase(String json) {
		JSONObject job = JSONObject.fromObject(json);
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

}
