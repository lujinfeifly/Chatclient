package com.bochatclient.packet;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bochatclient.enums.PacketConstant;
import com.bochatclient.utils.JSONHelper;
import com.bochatclient.utils.URLEncode;

public class PacketIntent {
	
	@SuppressWarnings("unchecked")
	public static PacketBase getPacket(int action, int type, String msg) {
		System.out.println("packet action:"+action+",type:"+type);
		PacketBase packet = null;
		
		int iselect = (action<<16) + type;
		
		if(PacketConstant.PacketType.SYS_HEART == iselect){
			return null;//心跳包
		}
		
		JSONObject job = new JSONObject(msg);
		Integer retcode = Integer.parseInt(job.optString("retcode"));
		String retmsg = job.optString("retmsg");
		int version = job.optInt("v");
		
		if(retcode!=0){//错误消息-后面的不用解析
			packet = new PacketBase();
			packet.setRetcode(retcode);
			packet.setRetmsg(retmsg);
			packet.setType(iselect);
			packet.setVersion(version);
			return packet;
		}
		
		String escapeflag = job.optString("escapeflag");
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		
		JSONObject jobct = null;
//		String content = null;
		if("1".equals(escapeflag)){
			String ct = msgjo.optString("ct");
			ct = URLEncode.unescape(ct);
//			try{
//				jobct = new JSONObject(ct);
//			}catch(Exception e){//不是json格式
//				content = ct;
//			}
			//把转换过的ct在放到msgjo中
			msgjo.put("ct", ct);
		}
		
		Object ct = msgjo.opt("ct");
		if(ct instanceof String){//是json格式
			try{
				jobct = new JSONObject(ct.toString());
			}catch(Exception e){
				//非jsonobject格式，直接解析msg[0]
			}
		}else if(ct instanceof JSONObject){//是json格式
			jobct = new JSONObject(ct.toString());
		}else if(ct instanceof JSONArray){//是jsonArray格式
			//观众列表 ct 是 jsonArray数组，结构不一样
			if(iselect==PacketConstant.PacketType.USER_LIST){
				JSONArray jarrct = new JSONArray(ct.toString());
				jobct = new JSONObject();
				for(int i=0;i<jarrct.length();i++){
					JSONObject jarrjob = jarrct.getJSONObject(i);
					Iterator<String> iter = jarrjob.keys();
					while (iter.hasNext()) {
						String key = iter.next();
						jobct.put(key, jarrjob.get(key));
					}
				}
			}
		}
		
		Class<PacketBase> clazz = PacketConstant.PacketClassEnum.getPacket(iselect);
		if(clazz==null){//未解析的消息类型
			System.out.println("消息类型没有解析-action:"+action+",type:"+type);
			return null;
		}
		if(iselect==0){
			System.out.println("登陆消息");
		}
//		if(content!=null||iselect==PacketConstant.PacketType.LOGIN_RET){//登陆包特殊处理
//			packet = JSONHelper.jsonToObject(msgjo, clazz);
//		}else 
		//ct是jsonObject 解析ct
		if(jobct!=null&&iselect!=PacketConstant.PacketType.LOGIN_RET){
			packet = JSONHelper.jsonToObject(jobct, clazz);
		}else{//ct 是 字符串或jsonArray
			packet = JSONHelper.jsonToObject(msgjo, clazz);
		}
		
//		try{
//			if(msgjo!=null){
//				
//				Class clazz = PacketPaserUtil.PacketClassEnum.getPacket(iselect);
//				packet = JSONHelper.jsonToObject(tojob, ChatUserSimpleBean.class);
//				packet = JSONHelper.jsonToObject(tojob, ChatUserSimpleBean.class);
//				
//				
//				
//				
//				switch(iselect) {
//				case PacketType.USER_MSG:
//					packet = new PacketUserMsg(msg);
//					break;
//					
//				case PacketType.USER_LIST:
//					packet = new PacketUserList(msg);
//					break;
//				case PacketType.SYST_MSG:
//					packet = new PacketSysMsg(msg);
//					break;
//				case PacketType.LEAVE_ROOM:
//					packet = new PacketLogoutRet(msg);
//					break;
//				case PacketType.LOGIN_RET:
//					packet = new PacketLoginRet(msg);
//					break;
//				case PacketType.GIFT_MSG:
//					packet = new PacketGiftMsg(msg);
//					break;
//				case PacketType.SYNC_COUNT:
//					packet = new PacketOnlineCountRet(msg);
//					break;
//				case PacketType.SYST_CHAT://开启关闭公聊
//					packet = new PacketChatInfo(msg);
//					break;
//				case PacketType.SYST_BANNED_CHAT://禁言
//					packet = new PacketBannedInfo(msg);
//					break;
//				case PacketType.SYST_UNBANNED_CHAT://解除禁言
//					packet = new PacketBannedInfo(msg);
//					break;
//				case PacketType.SYST_KICK://踢人
//					packet = new PacketBannedInfo(msg);
//					break;
//				case PacketType.SYST_SET_ADMIN://踢人
//					packet = new PacketAdminInfo(msg);
//					break;
//				case PacketType.USER_UPGRADE://等级提升
//					packet = new PacketUserUpgrade(msg);
//					break;
//				case PacketType.USER_CHARM://魅力等级同步
//					packet = new PacketUserCharm(msg);
//					break;
//				case PacketType.SYS_USER_MSG://飞屏
//					packet = new PacketUserMsg(msg);
//					break;
//				case PacketType.SYS_BROADCAST_MSG://广播
//					packet = new PacketBroadcast(msg);
//					break;
//				case PacketType.SYS_HEADLINE_MSG://头条
//					packet = new PacketHeadline(msg);
//					break;
//				case PacketType.LIVE_START://开播
//					packet = new PacketHeadline(msg);
//					break;
//				case PacketType.LIVE_END://关播
//					packet = new PacketHeadline(msg);
//					break;	
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	//			if(type==PacketIntent.PacketType.USER_MSG){//用户消息协议不规则MSG中多e和f
	//				
	//			} else if(type==PacketIntent.PacketType.USER_LIST){//用户列表
	//				
	//			}
		packet.setRetcode(retcode);
		packet.setRetmsg(retmsg);
		packet.setType(iselect);
		packet.setVersion(version);
		return packet;
	}
}
