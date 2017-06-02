package com.bochatclient.packet;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: PacketYbTotal.java
 * @Description: 7日打赏
 * @author renms
 * @date 2017年4月7日 下午2:24:41 
 * @version 1.0
 */
public class PacketYbTotal extends PacketBase{
	
	@Mapping("a")
	private long total;
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PacketYbTotal [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", total="
				+ total + "]";
	}
}
