package com.bochatclient.packet;


import java.util.List;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.UserMsgBean;
import com.bochatclient.bean.UserMsgBeanCT;
import com.bochatclient.utils.GsonUtil;
import com.google.gson.internal.StringMap;

public class PacketUserMsg extends PacketBase{
	
	
	
	public PacketUserMsg(String json) { 
		
		
		System.out.println("PacketUserMsg:"+json);
		
		BaseBean<StringMap<StringMap<String>>> bb = GsonUtil.GsonToBean(json, BaseBean.class);
		int retCode = Integer.parseInt(bb.getRetcode());
		this.retcode = retCode;
		
		System.out.println("gift:"+json);
		
		// 礼物中只会出现get(0),也就是只有一个元素
		
		List<StringMap<StringMap<String>>> list = bb.getMsg();
		StringMap<StringMap<String>> gb = null;
		if(list.size()>0){
			gb = list.get(0);
		}
		if(gb==null){
			return;
		}
		String typeStr = gb.get("b").toString();
		msg = gb.get("ct").toString();
		
		StringMap<String> gbct = gb.get("e");
		if(gbct != null) {
			userID = gbct.get("bb");
			nickName = gbct.get("p");
		}
		switch(Integer.parseInt(typeStr)) {
		case 0:  // 公开说
			break;
		case 1:   // 对某人说
			break;
		case 2:   // 悄悄对某人说
			break;
		}
	}
	
	@Override
	public boolean isMsg() {
		return true;
	}
}
