package com.bochatclient.packet;

import java.util.List;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatPkMasterBean;

/**
 * @ClassName: PacketPkTimeMsg.java
 * @Description: PK时间同步
 * @author renms
 * @date 2018年3月14日 下午2:24:19 
 * @version 1.0
 */
public class PacketPkTimeMsg extends PacketBase{
	
	
	@Mapping("a")
	private int timeType;//排名
	@Mapping("b")
	private long second;
	
	@Mapping(value="c",type="list",name="com.bochatclient.bean.ChatPkUserBean")
	private List<ChatPkMasterBean> userList;
	
	
	public int getTimeType() {
		return timeType;
	}
	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}
	public long getSecond() {
		return second;
	}
	public void setSecond(long second) {
		this.second = second;
	}
	public List<ChatPkMasterBean> getUserList() {
		return userList;
	}
	public void setUserList(List<ChatPkMasterBean> userList) {
		this.userList = userList;
	}
	
	@Override
	public String toString() {
		return "PacketPkTimeMsg [timeType=" + timeType + ", second=" + second + ", userList=" + userList + "]";
	}
}