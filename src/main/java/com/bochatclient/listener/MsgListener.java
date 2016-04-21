package com.bochatclient.listener;

import com.bochatclient.packet.PacketBase;

public interface MsgListener {
	public void onReciveMsg(PacketBase packet);
}
