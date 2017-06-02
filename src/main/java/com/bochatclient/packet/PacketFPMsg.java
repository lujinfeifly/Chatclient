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
	private int userId;//用户id
	@Mapping("c")
	private String msg;
	@Mapping("h")
	private String userName;//用户名称
	@Mapping("a")
	private int fensiLevel;//粉丝等级
	@Mapping("e")
	private int caifulevel;//财富等级
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFensiLevel() {
		return fensiLevel;
	}

	public void setFensiLevel(int fensiLevel) {
		this.fensiLevel = fensiLevel;
	}

	public int getCaifulevel() {
		return caifulevel;
	}

	public void setCaifulevel(int caifulevel) {
		this.caifulevel = caifulevel;
	}

	@Override
	public String toString() {
		return "PacketFPMsg [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", msgType="
				+ msgType + ", userId=" + userId + ", msg=" + msg + "]";
	}

}
