package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;


public class PacketOnlineCountRet extends PacketBase {
	
	@Mapping("b")
	private int general;
	@Mapping("c")
	private int caifu;
	

	public int getOnlineCount() {
		return general+caifu;
	}

	public int getGeneral() {
		return general;
	}

	public void setGeneral(int general) {
		this.general = general;
	}

	public int getCaifu() {
		return caifu;
	}

	public void setCaifu(int caifu) {
		this.caifu = caifu;
	}

	@Override
	public String toString() {
		return "PacketOnlineCountRet [retcode=" + retcode + ", retmsg="
				+ retmsg + ", type=" + type + ", version=" + version
				+ ", general=" + general + ", caifu=" + caifu + "]";
	}
}
