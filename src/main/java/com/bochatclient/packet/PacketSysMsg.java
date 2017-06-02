package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

public class PacketSysMsg extends PacketBase{
	
	@Mapping("mes")
	private String msg;
	
	//不显示系统公告的房间id,以 "," 分隔
	@Mapping("anchorIds")
	private String anchorIds;
	
	//0-只在公聊显示 1-只在私聊显示 2-公聊私聊都显示
	@Mapping("broad")
	private int broad;
	
	@Mapping("client")
	private int client;
	
	@Mapping("links")
	private String links;
	
	//0-普通消息无连接 1-跳转到官网 2-跳转直播间   
	@Mapping("linkType")
	private int linkType;
	
	public String getSender() {
		return "系统消息";
	}

	public String getAnchorIds() {
		return anchorIds;
	}

	public void setAnchorIds(String anchorIds) {
		this.anchorIds = anchorIds;
	}

	public String getMsg() {
		return msg;
	}

	public int getBroad() {
		return broad;
	}

	public void setBroad(int broad) {
		this.broad = broad;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public int getLinkType() {
		return linkType;
	}

	public void setLinkType(int linkType) {
		this.linkType = linkType;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "PacketSysMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", msg=" + msg
				+ "]";
	}
}
