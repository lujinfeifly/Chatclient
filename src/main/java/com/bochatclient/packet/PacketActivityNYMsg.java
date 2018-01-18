package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

public class PacketActivityNYMsg extends PacketBase {
	@Mapping("rank")
	private int rank; //类型

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "PacketActivityNYMsg [rank=" + rank + "]";
	}
	
}
