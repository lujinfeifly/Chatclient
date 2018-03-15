package com.bochatclient.packet;


import java.util.List;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatPkUserBean;


/**
 * @ClassName: PacketPkResultMsg.java
 * @Description: PK结果
 * @author renms
 * @date 2018年3月14日 下午3:29:20 
 * @version 1.0
 */
public class PacketPkResultMsg extends PacketBase{

	@Mapping("a")
	private int reType;//类型，1-胜/2-负/3-平
	@Mapping("c")
	private int gxValue;//贡献值
	@Mapping(value="b",type="list",name="com.bochatclient.bean.ChatPkUserBean")
	private List<ChatPkUserBean> userList;

	public int getReType() {
		return reType;
	}

	public void setReType(int reType) {
		this.reType = reType;
	}

	public int getGxValue() {
		return gxValue;
	}

	public void setGxValue(int gxValue) {
		this.gxValue = gxValue;
	}

	public List<ChatPkUserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<ChatPkUserBean> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "PacketPkResultMsg [reType=" + reType + ", gxValue=" + gxValue + ", userList=" + userList + "]";
	}
}
