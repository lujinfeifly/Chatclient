package com.bochatclient.packet;

import java.util.List;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.MsgBean;
import com.bochatclient.bean.SysBeanCT;
import com.bochatclient.utils.GsonUtil;
import com.google.gson.internal.StringMap;

public class PacketSysMsg extends PacketBase{
	
	@Override
	public boolean isMsg() {
		return true;
	}

	public PacketSysMsg(String json) {
		
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
		
		StringMap<String> gbct = gb.get("ct");
		if(gbct != null) {
			msg = gbct.get("mes");
		}
	}
}
