package com.bochatclient.packet;

public class PacketIntent {
	
	public class PacketType {
		public static final int USER_MSG = (100<<16) + 100; // action 100 type 100
		public static final int SYST_MSG = (24<<16) + 1;    // action 24 type 1     系统公告
		public static final int LOGIN_RET = 0;              // action 0 tyoe 0
	}

	public static PacketBase getPacket(int action, int type, String msg) {
		
		int iselect = (action<<16) + type;
		
		PacketBase packet = null;
		
		switch(iselect) {
		case PacketType.USER_MSG:
			packet = new PacketUserMsg(msg);
			break;
		case PacketType.SYST_MSG:
			packet = new PacketSysMsg(msg);
			break;
		case PacketType.LOGIN_RET:
			packet = new PacketLoginRet(msg);
			break;
		}
		
		return packet;
		
	}
}
