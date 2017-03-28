package com.bochatclient.packet;

public class PacketIntent {
	
	public class PacketType {
		public static final int USER_MSG = (0<<16) + 2;     // action 0 type 2       用户消息
		public static final int USER_LIST = (0<<16) + 6;     // action 0 type 2       用户消息
		public static final int SYST_MSG = (24<<16) + 1;    // action 24 type 1     系统公告
		public static final int GIFT_MSG = (3<<16) + 1;     // action 3  type 1     礼物消息
		
		public static final int LOGIN_RET = 0;              // action 0 tyoe 0   进入房间
		
		public static final int LEAVE_ROOM = (1<<16) + 0;   // action 1 type 0  用户离开房间
		public static final int SYNC_COUNT = (84<<16)+ 1;   // action 84 type 1 同步人员个数
		public static final int SYNC_MASTER = (86<<16)+ 1;   // action 86 type 1 主播信息
	}

	public static PacketBase getPacket(int action, int type, String msg) {
		
		int iselect = (action<<16) + type;
		
		PacketBase packet = null;
		try{
			switch(iselect) {
			case PacketType.USER_MSG:
				packet = new PacketUserMsg(msg);
				break;
			case PacketType.USER_LIST:
				packet = new PacketUserList(msg);
				break;
			case PacketType.SYST_MSG:
				packet = new PacketSysMsg(msg);
				break;
			case PacketType.LEAVE_ROOM:
				packet = new PacketLogoutRet(msg);
				break;
			case PacketType.LOGIN_RET:
				packet = new PacketLoginRet(msg);
				break;
			case PacketType.GIFT_MSG:
				packet = new PacketGiftMsg(msg);
				break;
			case PacketType.SYNC_COUNT:
				packet = new PacketOnlineCountRet(msg);
				break;
			case PacketType.SYNC_MASTER://同步主播信息
//				packet = new PacketOnlineCountRet(msg);
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return packet;
		
	}
}
