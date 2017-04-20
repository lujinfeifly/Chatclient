package com.bochatclient.packet;


import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketUserMsg.java
 * @Description: 飞屏消息
 * @author renms
 * @date 2017年4月7日 下午2:25:15 
 * @version 1.0
 */
public class PacketFPMsg extends PacketBase{
	
	
	@Mapping("b")
	private int msgType;//飞屏类型 113 114 115
	@Mapping("bb")
	private int userId;//飞屏类型
	@Mapping("c")
	private String msg;
	
	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "PacketFPMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", msgType="
				+ msgType + ", userId=" + userId + ", msg=" + msg + "]";
	}

}
