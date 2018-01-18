package com.bochatclient.enums;

import com.bochatclient.packet.PacketActivityGift;
import com.bochatclient.packet.PacketActivityNYMsg;
import com.bochatclient.packet.PacketActivitySDMsg;
import com.bochatclient.packet.PacketAdminInfo;
import com.bochatclient.packet.PacketAudioStateMsg;
import com.bochatclient.packet.PacketBannedInfo;
import com.bochatclient.packet.PacketBroadcast;
import com.bochatclient.packet.PacketChatInfo;
import com.bochatclient.packet.PacketFPMsg;
import com.bochatclient.packet.PacketGiftComboMsg;
import com.bochatclient.packet.PacketGiftFMsg;
import com.bochatclient.packet.PacketGiftFail;
import com.bochatclient.packet.PacketGiftMsg;
import com.bochatclient.packet.PacketGiveRepMsg;
import com.bochatclient.packet.PacketHeadline;
import com.bochatclient.packet.PacketLiveEnd;
import com.bochatclient.packet.PacketLiveStart;
import com.bochatclient.packet.PacketLoginRet;
import com.bochatclient.packet.PacketLogoutRet;
import com.bochatclient.packet.PacketOnlineCountRet;
import com.bochatclient.packet.PacketOpenRepMsg;
import com.bochatclient.packet.PacketSubCount;
import com.bochatclient.packet.PacketSysMsg;
import com.bochatclient.packet.PacketTakeRepMsg;
import com.bochatclient.packet.PacketUserCharm;
import com.bochatclient.packet.PacketUserInfo;
import com.bochatclient.packet.PacketUserList;
import com.bochatclient.packet.PacketUserMsg;
import com.bochatclient.packet.PacketUserUpgrade;
import com.bochatclient.packet.PacketVIPUpgrade;
import com.bochatclient.packet.PacketYbTotal;

public class PacketConstant {
	
	public class PacketType {
		public static final int USER_MSG = (0<<16) + 2;     // action 0 type 2  公聊消息
		public static final int USER_MSG_1 = (1<<16) + 2;     // action 1 type 2       用户消息
		public static final int USER_MSG_2 = (2<<16) + 2;     // action 2 type 2       用户消息
//		public static final int USER_LIST = (0<<16) + 6;     // action 0 type 6      观众列表
		public static final int USER_LIST = (1<<16) + 6;     // action 1 type 6      观众列表（移动端定制）
		public static final int SYST_MSG = (24<<16) + 1;    // action 24 type 1     系统公告
		public static final int LIVE_START = (15<<16) + 1;    // action 15 type 1    开播通知
		public static final int LIVE_END = (18<<16) + 1;    // action 18 type 1     关播通知
		public static final int GIFT_MSG = (3<<16) + 1;     // action 3  type 1     礼物消息
		public static final int GIFT_COMBO_MSG = (82<<16) + 1;	// action 82  type 1     礼物连接动画
		public static final int LOGIN_RET = 0;              // action 0 tyoe 0   进入房间
		public static final int LEAVE_ROOM = (1<<16) + 0;   // action 1 type 0  用户离开房间
		public static final int SYNC_COUNT = (84<<16)+ 1;   // action 84 type 1 同步人员个数
		public static final int SYNC_MASTER = (86<<16)+ 1;   // action 86 type 1 主播信息
		public static final int SYST_CHAT = (11<<16)+ 1;   // action 11 type 1 关闭/开启公聊
		public static final int SYST_BANNED_CHAT = (1<<16)+ 4;   // action 1 type 4 禁言消息
		public static final int SYST_UNBANNED_CHAT = (2<<16)+ 4;   // action 2 type 4 解除禁言消息
		public static final int SYST_KICK = (0<<16)+ 4;   // action 2 type 4 踢人消息
		public static final int SYST_SET_ADMIN = (13<<16)+ 1;   // action 13 type 1 设置管理员/撤销
		public static final int USER_UPGRADE = (20<<16)+ 1;   // action 20 type 1 主播|粉丝|财富 等级提升
		public static final int USER_CHARM = (79<<16)+ 1;   // action 79 type 1 魅力等级同步
		public static final int SYS_FP_MSG = (74<<16)+ 1;   // action 74 type 1 飞屏消息
		public static final int SYS_BROADCAST_MSG = (31<<16)+ 1;   // action 31 type 1 广播消息
		public static final int SYS_HEADLINE_MSG = (12<<16)+ 1;   // action 12 type 1头条消息
		
		public static final int SYS_HEART = (3<<16)+ 0;   // action 3 type 0 心跳包
		public static final int VIP_UPLEVEL = (81<<16)+ 1;   // action 81 type 1 天龙角色vip升级消息
		public static final int YUANBAO_TOTAL = (93<<16)+ 1;   // action 93 type 1 直播间的7日总数
		public static final int SUB_TOTAL = (66<<16)+ 1;   // action 66 type 1 关注数同步
		public static final int SEND_GIFT_FAIL = (111<<16)+1;	// action 111 type 1 送礼结果返回
		public static final int USER_INFO = (4<<16) + 2;     // action 4 type 2       用户详细信息
		public static final int FREE_GIFT_MSG = (102<<16) + 1;     // action 102 type 1     免费礼物消息
		public static final int AUDIO_STATE_MSG = (25<<16) + 1;     // action 25 type 1     开关麦克风
		
		public static final int GIVE_REP_MSG = (105<<16) + 1;     // action 105 type 1    打赏红包消息
		public static final int OPEN_REP_MSG = (106<<16) + 1;     // action 106 type 1    开启红包消息
		public static final int TAKE_REP_MSG = (107<<16) + 1;     // action 107 type 1    领取红包消息
		
		public static final int LM_START = (103<<16) + 1;    // action 103 type 1    开启连麦
		public static final int LM_END = (104<<16) + 1;    // action 104 type 1    关闭连麦
		//圣诞节活动
		public static final int ACTIVITY_SD_MSG = (225<<16) + 1;     // action 225 type 1     圣诞节活动
		public static final int ACTIVITY_Gift_MSG = (83<<16) + 1;     // action 83 type 1    圣诞节礼物消息
		
		
		public static final int ACTIVITY_NY_MSG = (109<<16) + 1;     // action 109 type 1    春节活动（新春装上爱）
	}
	
	// 发送消息类型
	public static class MsgType{
		public static final int MSG_PUB = 0;//公聊-所有人可见
		public static final int MSG_PRV = 1;//私聊-所有人可见
		public static final int MSG_PRVO = 2;//私聊-接收人可见
	}
	
	//系统公告 广播消息展示类型
	public static class SysBoradType{
		public static final int BROAD_PUB = 0;//0-只在公聊显示
		public static final int BROAD_PRV = 1;//1-只在私聊显示
		public static final int BROAD_ALL = 2;//2-公聊私聊都显示
	}
	
	//系统公告 广播消息跳转类型
	public static class SysLinkType{
		public static final int SYS_NORMAL = 0;//0-普通消息无跳转
		public static final int SYS_GW = 1;//1-跳转到官网
		public static final int SYS_ROOM = 2;//2-跳转到直播间
	}
	
	// 用户类型
	public static class UserType{
		public static final int USER_JR = 5;//假人
		public static final int USER_XG = 10;//巡管
		public static final int USER_GZ = 30;//观众
		public static final int USER_GLY = 40;//管理员
		public static final int USER_ZB = 50;//主播
	}
	
	// 升级类型枚举：5-观众粉丝等级提升/3-观众财富等级提升/2-主播等级升级
	public static class UpgradeType{
		public static final int MASTER_LEVEL = 2;//假人
		public static final int USER_CF_LEVEL = 3;//巡管
		public static final int USER_FX_LEVEL = 5;//观众
	}
	
	// 房间角色
	public static class RoomRole{
		public static final int ROLE_FZ = 1;//房主
		public static final int ROLE_ZB = 3;//主播
		public static final int ROLE_FG = 4;//房管
	}
	
	public enum PacketClassEnum{
		USER_MSG(PacketType.USER_MSG,PacketUserMsg.class),
		USER_MSG_2(PacketType.USER_MSG_2,PacketUserMsg.class),
//		USER_LIST(PacketType.USER_LIST,PacketUserList.class),
		USER_LIST(PacketType.USER_LIST,PacketUserList.class),
		SYST_MSG(PacketType.SYST_MSG,PacketSysMsg.class),
		LIVE_START(PacketType.LIVE_START,PacketLiveStart.class),
		LIVE_END(PacketType.LIVE_END,PacketLiveEnd.class),
		LM_START(PacketType.LM_START,PacketLiveStart.class),
		LM_END(PacketType.LM_END,PacketLiveEnd.class),
		GIFT_MSG(PacketType.GIFT_MSG,PacketGiftMsg.class),
		GIFT_COMBO_MSG(PacketType.GIFT_COMBO_MSG,PacketGiftComboMsg.class),
		LOGIN_RET(PacketType.LOGIN_RET,PacketLoginRet.class),
		LEAVE_ROOM(PacketType.LEAVE_ROOM,PacketLogoutRet.class),
		SYNC_COUNT(PacketType.SYNC_COUNT,PacketOnlineCountRet.class),
		SYNC_MASTER(PacketType.SYNC_MASTER,PacketUserInfo.class),
		SYST_CHAT(PacketType.SYST_CHAT,PacketChatInfo.class),
		SYST_BANNED_CHAT(PacketType.SYST_BANNED_CHAT,PacketBannedInfo.class),
		SYST_UNBANNED_CHAT(PacketType.SYST_UNBANNED_CHAT,PacketBannedInfo.class),
		SYST_KICK(PacketType.SYST_KICK,PacketBannedInfo.class),
		SYST_SET_ADMIN(PacketType.SYST_SET_ADMIN,PacketAdminInfo.class),
		USER_UPGRADE(PacketType.USER_UPGRADE,PacketUserUpgrade.class),
		USER_CHARM(PacketType.USER_CHARM,PacketUserCharm.class),
		SYS_FP_MSG(PacketType.SYS_FP_MSG,PacketFPMsg.class),
		SYS_BROADCAST_MSG(PacketType.SYS_BROADCAST_MSG,PacketBroadcast.class),
		SYS_HEADLINE_MSG(PacketType.SYS_HEADLINE_MSG,PacketHeadline.class),
		VIP_UPGRADE_MSG(PacketType.VIP_UPLEVEL,PacketVIPUpgrade.class),
		YB_TOTAL_MSG(PacketType.YUANBAO_TOTAL,PacketYbTotal.class),
		SUB_TOTAL_MSG(PacketType.SUB_TOTAL,PacketSubCount.class),
		SEND_GIFT_RET(PacketType.SEND_GIFT_FAIL,PacketGiftFail.class),
		USER_INFO_MSG(PacketType.USER_INFO,PacketUserInfo.class),
		FREE_GIFT_MSG(PacketType.FREE_GIFT_MSG,PacketGiftFMsg.class),
		AUDIO_STATE_DEMO(PacketType.AUDIO_STATE_MSG,PacketAudioStateMsg.class),
		ACTIVITY_GIFT_MSG(PacketType.ACTIVITY_Gift_MSG,PacketActivityGift.class),
		ACTIVITY_SD_MSG(PacketType.ACTIVITY_SD_MSG,PacketActivitySDMsg.class),
		ACTIVITY_NY_MSG(PacketType.ACTIVITY_NY_MSG,PacketActivityNYMsg.class),
		GIVE_REP_MSG(PacketType.GIVE_REP_MSG,PacketGiveRepMsg.class),
		OPEN_REP_MSG(PacketType.OPEN_REP_MSG,PacketOpenRepMsg.class),
		TAKE_REP_MSG(PacketType.TAKE_REP_MSG,PacketTakeRepMsg.class);
		
		private int key;
		private Class clazz;
		
		PacketClassEnum(int key,Class clazz){
			this.key = key;
			this.clazz = clazz;
		}
		
		public static Class getPacket(int key) {  
	        for (PacketClassEnum c : PacketClassEnum.values()) {  
	            if (c.getKey() == key) {  
	                return c.getClazz();
	            }
	        }  
	        return null;  
	    }

		public int getKey() {
			return key;
		}

		public Class getClazz() {
			return clazz;
		}
	}
	
	public enum CloseCodeEnum{
		code_0(0,"初始默认"),
		code_1(1,"异常关闭"),
		code_2(2,"主播关闭"),
		code_3(3,"管理关闭"),
		code_4(4,"强制断流"),
		code_5(5,"余额不足"),
		code_6(6,"断流超时"),
		code_7(7,"状态监测"),
		code_8(8,"切麦关闭"),
		code_9(9,"房间关闭"),
		code_10(10,"封号/封IP");
		
		private int key;
		private String name;
		
		CloseCodeEnum(int key,String name){
			this.key = key;
			this.name = name;
		}
		
		public static String getPacket(int key) {  
	        for (CloseCodeEnum c : CloseCodeEnum.values()) {  
	            if (c.getKey() == key) {  
	                return c.getName();
	            }
	        }  
	        return null;  
	    }

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}

	}
}
