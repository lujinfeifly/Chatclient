package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketGiveRepMsg.java
 * @Description: 红包消息-打赏红包
 * @author renms
 * @date 2017年1月9日 下午2:24:19 
 * @version 1.0
 */
public class PacketGiveRepMsg extends PacketBase{
	
	@Mapping(value="a",type="object")
	private ChatUserSimpleBean sendUserBean;
	
	@Mapping("b")
	private int repId;//红包id
	@Mapping("c")
	private int num;//红包数量
	@Mapping("d")
	private int money;//红包价值
	@Mapping("e")
	private int packetType;//红包类型；1：星钻红包
	@Mapping("f")
	private long startTime;//红包开启时间
	
	public ChatUserSimpleBean getSendUserBean() {
		return sendUserBean;
	}
	public void setSendUserBean(ChatUserSimpleBean sendUserBean) {
		this.sendUserBean = sendUserBean;
	}
	public int getRepId() {
		return repId;
	}
	public void setRepId(int repId) {
		this.repId = repId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public int getPacketType() {
		return packetType;
	}
	public void setPacketType(int packetType) {
		this.packetType = packetType;
	}
	@Override
	public String toString() {
		return "PacketGiveRepMsg [userBean=" + sendUserBean + ", repId=" + repId + ", num=" + num + ", money=" + money
				+ ", startTime=" + startTime + "]";
	}
}
