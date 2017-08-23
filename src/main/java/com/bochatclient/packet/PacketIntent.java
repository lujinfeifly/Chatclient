package com.bochatclient.packet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bochatclient.enums.PacketConstant;
import com.bochatclient.utils.JSONHelper;
import com.bochatclient.utils.URLEncode;

public class PacketIntent {
	
	@SuppressWarnings("unchecked")
	public static List<PacketBase> getPacket(int action, int type, String msg) {
		PacketBase packet = null;
		int iselect = (action<<16) + type;
		if(PacketConstant.PacketType.SYS_HEART == iselect){
			return null;//心跳包
		}
		JSONObject job = new JSONObject(msg);
		Integer retcode = Integer.parseInt(job.optString("retcode"));
		String retmsg = job.optString("retmsg");
		int version = job.optInt("v");
		
		List<PacketBase> retList = new ArrayList<PacketBase>();
		if(retcode!=0){//错误消息-后面的不用解析
			packet = new PacketBase();
			packet.setRetcode(retcode);
			packet.setRetmsg(retmsg);
			packet.setType(iselect);
			packet.setVersion(version);
			retList.add(packet);
			return retList;
		}
		
		String escapeflag = job.optString("escapeflag");
		JSONArray jarry = job.optJSONArray("msg");
		for(int z=0;z<jarry.length();z++){
			JSONObject msgjo = (JSONObject)jarry.get(z);
//			JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
			
			JSONObject jobct = null;
//			String content = null;
			if("1".equals(escapeflag)){
				String ct = msgjo.optString("ct");
				ct = URLEncode.unescape(ct);
//				try{
//					jobct = new JSONObject(ct);
//				}catch(Exception e){//不是json格式
//					content = ct;
//				}
				//把转换过的ct在放到msgjo中
				msgjo.put("ct", ct);
			}
			
			Object ct = msgjo.opt("ct");
			System.out.println(ct);
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
							Object obj = jarrjob.get(key).toString().equals("null")?"[]":jarrjob.get(key);
							jobct.put(key, obj);
						}
					}
				}
			}else{
				return null;
			}
			
			Class<PacketBase> clazz = PacketConstant.PacketClassEnum.getPacket(iselect);
			if(clazz==null){//未解析的消息类型
				System.out.println("消息类型没有解析-action:"+action+",type:"+type);
				return null;
			}
			//ct是jsonObject 解析ct
			if(jobct!=null
					&&iselect!=PacketConstant.PacketType.LOGIN_RET
					&&iselect!=PacketConstant.PacketType.USER_INFO
					&&iselect!=PacketConstant.PacketType.SYNC_MASTER){
				packet = JSONHelper.jsonToObject(jobct, clazz);
			}else{//ct 是 字符串或jsonArray
				packet = JSONHelper.jsonToObject(msgjo, clazz);
			}
			
			packet.setRetcode(retcode);
			packet.setRetmsg(retmsg);
			packet.setType(iselect);
			packet.setVersion(version);
			retList.add(packet);
		}
		return retList;
	}
}
