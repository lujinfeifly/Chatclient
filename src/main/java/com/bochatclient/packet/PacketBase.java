package com.bochatclient.packet;


public class PacketBase {
	
	protected String nickName;
	protected String msg;
	protected String userID;
	protected int retcode;
	
	
	public PacketBase() {
		super();
	}

	public int getRetcode() {
		return retcode;
	}

	public PacketBase(String retcode) {
		System.out.println("PacketBase retcode==="+retcode);
//		JSONObject job = JSONObject.fromObject(retcode);
//		this.retcode = job.getInt("retcode");
		this.retcode = Integer.parseInt(retcode);
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
