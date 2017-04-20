package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

public class PacketSysMsg extends PacketBase{
	
	@Mapping("mes")
	private String msg;
	
	public String getSender() {
		return "系统消息";
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "PacketSysMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", msg=" + msg
				+ "]";
	}
}
