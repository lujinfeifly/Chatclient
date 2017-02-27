package com.bochatclient.packet;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.MsgBean;
import com.bochatclient.utils.GsonUtil;


public class PacketLoginRet extends PacketBase {
	
	
	public PacketLoginRet(String json) {
		
		BaseBean<MsgBean<String>> bb = GsonUtil.GsonToBean(json, BaseBean.class);
		int retCode = Integer.parseInt(bb.getRetcode());
		System.out.println("登陆成功返回："+retCode);
		this.retcode = retCode;
	}
}
