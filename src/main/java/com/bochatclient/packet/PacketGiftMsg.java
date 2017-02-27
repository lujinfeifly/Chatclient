package com.bochatclient.packet;

import java.util.List;

import com.bochatclient.bean.BaseBean;
import com.bochatclient.bean.GiftBeanCT;
import com.bochatclient.bean.MsgBean;
import com.bochatclient.utils.GsonUtil;

public class PacketGiftMsg extends PacketBase {
	@Override
	public boolean isMsg() {
		return true;
	}

	public PacketGiftMsg(String json) {
		
		BaseBean<MsgBean<GiftBeanCT>> bb = GsonUtil.GsonToBean(json, BaseBean.class);
		int retCode = Integer.parseInt(bb.getRetcode());
		this.retcode = retCode;
		
		System.out.println("gift:"+json);
		
		// 礼物中只会出现get(0),也就是只有一个元素
		
		List<MsgBean<GiftBeanCT>> list = bb.getMsg();
		MsgBean<GiftBeanCT> gb = null;
		if(list.size()>0){
			gb = list.get(0);
		}
		if(gb==null){
			return;
		}
		
		GiftBeanCT gbct = gb.getCt();
		if(gbct != null) {
			System.out.println(gbct.toString());
			// 发送人id
			userID = gbct.getBb();
			nickName = gbct.getB9();
			msg = "我送了" + gbct.getQ();
		}
	}
}
