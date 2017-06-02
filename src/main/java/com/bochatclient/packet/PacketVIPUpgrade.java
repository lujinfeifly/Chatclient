package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketVIPUpgrade.java
 * @Description: 天龙vip等级提升
 * @author renms
 * @date 2017年4月7日 下午2:24:41 
 * @version 1.0
 */
public class PacketVIPUpgrade extends PacketBase{
	
	
	@Mapping("bb")
	private long userId;
	@Mapping("b")
	private int olevel;
	@Mapping("c")
	private int nlevel;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getOlevel() {
		return olevel;
	}
	public void setOlevel(int olevel) {
		this.olevel = olevel;
	}
	public int getNlevel() {
		return nlevel;
	}
	public void setNlevel(int nlevel) {
		this.nlevel = nlevel;
	}
	@Override
	public String toString() {
		return "PacketVIPUpgrade [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", userId="
				+ userId + ", olevel=" + olevel + ", nlevel=" + nlevel + "]";
	}
}
