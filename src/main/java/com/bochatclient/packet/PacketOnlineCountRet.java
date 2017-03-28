package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.enums.PacketConstant;


public class PacketOnlineCountRet extends PacketBase {
	private int onlineCount;
	
	public PacketOnlineCountRet(String json) {
		super();
		
		this.type=PacketConstant.PacketType.ONLINE_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		
		String escapeflag = job.optString("escapeflag");
		String ct = msgjo.optString("ct");
		//是否需要转码
		if("1".equals(escapeflag)){
			ct = URLEncode.unescape(ct);
		}
		
		JSONObject ujob = new JSONObject(ct);
		if(ujob!=null){
			int general = ujob.optInt("b");
			int caifu = ujob.optInt("c");
			onlineCount = general+caifu;
		}
	}

	public int getOnlineCount() {
		return onlineCount;
	}

	@Override
	public String toString() {
		return "PacketOnlineCountRet [onlineCount=" + onlineCount
				+ ", retcode=" + retcode + ", type=" + type + "]";
	}
	
}
