package com.bochatclient.enums;

public class PacketConstant {
	
	// 解析包类型
	public static class PacketType{
		public static final int GIFT_MSG = 1;//礼物消息
		public static final int LOGIN_MSG = 2;//进入房间
		public static final int USER_LIST_MSG = 3;//在线列表
		public static final int USER_MSG = 4;//聊天消息类：私聊和公聊
		public static final int LOGOUT_MSG = 5;//退出房间
		public static final int ONLINE_MSG = 6;//房间在线人数
		public static final int SYS_MSG = 99;//系统公告
	}
	
	// 发送消息类型
	public static class MsgType{
		public static final int MSG_PUB = 0;//公聊-所有人可见
		public static final int MSG_PRV = 1;//私聊-所有人可见
		public static final int MSG_PRVO = 2;//私聊-接收人可见
	}
	
	// 用户类型
	public static class UserType{
		public static final int USER_JR = 5;//假人
		public static final int USER_XG = 10;//巡管
		public static final int USER_GZ = 30;//观众
		public static final int USER_GLY = 40;//管理员
		public static final int USER_ZB = 50;//主播
	}
	
	// 房间角色
	public static class RoomRole{
		public static final int ROLE_FZ = 1;//房主
		public static final int ROLE_ZB = 3;//主播
		public static final int ROLE_FG = 4;//房管
	}
	
}
