package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserSimpleBean;

/**
 * @ClassName: PacketBannedInfo.java
 * @Description: 升级消息-包括：观众粉丝等级、观众财富等级、主播等级
 * @author renms
 * @date 2017年4月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketUserUpgrade extends PacketBase{
	
	//升级类型枚举：5-观众粉丝等级提升/3-观众财富等级提升/2-主播等级升级
	@Mapping("l")
	private int upgradeType;
	@Mapping("c")
	private int level;//当前级别
	@Mapping("q")
	private int exper;//当前经验值
	@Mapping("h")
	private int nextLevel;
	@Mapping("e")
	private int nextExper;//到下一级需要的经验
	@Mapping(value="n",type="object")
	private ChatUserSimpleBean userBean;
	public int getUpgradeType() {
		return upgradeType;
	}
	public void setUpgradeType(int upgradeType) {
		this.upgradeType = upgradeType;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExper() {
		return exper;
	}
	public void setExper(int exper) {
		this.exper = exper;
	}
	public int getNextLevel() {
		return nextLevel;
	}
	public void setNextLevel(int nextLevel) {
		this.nextLevel = nextLevel;
	}
	public int getNextExper() {
		return nextExper;
	}
	public void setNextExper(int nextExper) {
		this.nextExper = nextExper;
	}
	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}
	public void setUserBean(ChatUserSimpleBean userBean) {
		this.userBean = userBean;
	}
	@Override
	public String toString() {
		return "PacketUserUpgrade [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", upgradeType="
				+ upgradeType + ", level=" + level + ", exper=" + exper
				+ ", nextLevel=" + nextLevel + ", nextExper=" + nextExper
				+ ", userBean=" + userBean + "]";
	}
}
