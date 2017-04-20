package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketBannedInfo.java
 * @Description: 主播的魅力等级消息
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketUserCharm extends PacketBase{
	
	@Mapping("b")
	private int level;//当前级别
	@Mapping("c")
	private int nextLevel;
	@Mapping("a")
	private int nextExper;//到下一级需要的经验
	
	public int getLevel() {
		return level;
	}
	public int getNextLevel() {
		return nextLevel;
	}
	public int getNextExper() {
		return nextExper;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setNextLevel(int nextLevel) {
		this.nextLevel = nextLevel;
	}
	public void setNextExper(int nextExper) {
		this.nextExper = nextExper;
	}
	@Override
	public String toString() {
		return "PacketUserCharm [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", level="
				+ level + ", nextLevel=" + nextLevel + ", nextExper="
				+ nextExper + "]";
	}
}
