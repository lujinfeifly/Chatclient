package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketRoomRankingMsg.java
 * @Description: 直播间排行榜
 * @author renms
 * @date 2018年2月7日 下午2:24:19 
 * @version 1.0
 */
public class PacketRoomRankingMsg extends PacketBase{
	
	
	@Mapping("a")
	private int rank;//排名
	@Mapping("b")
	private long next;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getNext() {
		return next;
	}
	public void setNext(long next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "PacketRoomRankingMsg [rank=" + rank + ", next=" + next + "]";
	}
}