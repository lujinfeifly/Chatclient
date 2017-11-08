package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;


public class PacketGiftFail extends PacketBase {
	
	@Mapping("masterId")
	private int masterId;
	@Mapping("msg")
	private String msg;
	@Mapping("giftUID")
	private String giftUuid;
	@Mapping("code")
	private String code;
	
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getGiftUuid() {
		return giftUuid;
	}
	public void setGiftUuid(String giftUuid) {
		this.giftUuid = giftUuid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "PacketGiftFail [retcode=" + retcode + ", retmsg=" + retmsg + ", type=" + type + ", version=" + version
				+ ", masterId=" + masterId + ", msg=" + msg + ", giftUuid=" + giftUuid + ", code=" + code + "]";
	}
}
