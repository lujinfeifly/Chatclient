package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketGiveRepMsg.java
 * @Description: 红包消息-开启红包
 * @author renms
 * @date 2017年1月9日 下午2:24:19 
 * @version 1.0
 */
public class PacketTakeRepMsg extends PacketBase{
	
	@Mapping(value="a",type="object")
	private ChatUserSimpleBean sendUserBean;//发包人
	
	@Mapping(value="b",type="object")
	private ChatUserSimpleBean receiveUserBean;//收包人
	
	@Mapping("c")
	private int repId;//红包id
	@Mapping("d")
	private int num;//红包数量
	@Mapping("e")
	private int money;//红包价值
	@Mapping("f")
	private int packetType;//红包类型；1：星钻红包
	
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
	public int getPacketType() {
		return packetType;
	}
	public void setPacketType(int packetType) {
		this.packetType = packetType;
	}
	public ChatUserSimpleBean getSendUserBean() {
		return sendUserBean;
	}
	public void setSendUserBean(ChatUserSimpleBean sendUserBean) {
		this.sendUserBean = sendUserBean;
	}
	public ChatUserSimpleBean getReceiveUserBean() {
		return receiveUserBean;
	}
	public void setReceiveUserBean(ChatUserSimpleBean receiveUserBean) {
		this.receiveUserBean = receiveUserBean;
	}
	@Override
	public String toString() {
		return "PacketTakeRepMsg [sendUserBean=" + sendUserBean + ", receiveUserBean=" + receiveUserBean + ", repId="
				+ repId + ", num=" + num + ", money=" + money + "]";
	}
	
}
