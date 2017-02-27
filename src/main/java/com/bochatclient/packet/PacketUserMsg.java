package com.bochatclient.packet;


import java.util.List;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.UserMsgBean;
import com.bochatclient.bean.UserMsgBeanCT;
import com.bochatclient.utils.GsonUtil;

public class PacketUserMsg extends PacketBase{
	
	
	
	public PacketUserMsg(String json) { 
		
		BaseBean<UserMsgBean<UserMsgBeanCT>> bb = GsonUtil.GsonToBean(json, BaseBean.class);
		int retCode = Integer.parseInt(bb.getRetcode());
		this.retcode = retCode;
		
		System.out.println("gift:"+json);
		
		// 礼物中只会出现get(0),也就是只有一个元素
		
		List<UserMsgBean<UserMsgBeanCT>> list = bb.getMsg();
		UserMsgBean<UserMsgBeanCT> gb = null;
		if(list.size()>0){
			gb = list.get(0);
		}
		if(gb==null){
			return;
		}
		String typeStr = gb.getB();
		msg = gb.getCt();
		
		UserMsgBeanCT gbct = gb.getE();
		if(gbct != null) {
			userID = gbct.getBb();
			nickName = gbct.getP();
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
