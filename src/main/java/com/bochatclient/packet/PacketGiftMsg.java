package com.bochatclient.packet;

import org.json.JSONObject;

import com.bochatclient.URLEncode;
import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.GiftBean;
import com.bochatclient.enums.PacketConstant;

public class PacketGiftMsg extends PacketBase {
	protected String msg;
	private ChatUserSimpleBean userBean;
	private GiftBean giftBean;
	
	public PacketGiftMsg(String json) {
		super();
		this.type=PacketConstant.PacketType.GIFT_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		// 礼物中只会出现get(0),也就是只有一个元素
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		String typeStr = job.optString("escapeflag");
		
		String ct = msgjo.optString("ct");
		String jsonct = "{}";
		if(ct != null) {
			jsonct = URLEncode.unescape(ct);
			userBean = new ChatUserSimpleBean();
			JSONObject jobct = new JSONObject(jsonct);
			userBean.setUserId(Integer.parseInt(jobct.optString("b2")));
			userBean.setUserName(jobct.optString("b9"));
			int fensi = jobct.optInt("e");
			int caifu = jobct.optInt("b7");
			userBean.setFensiLevel(fensi);
			userBean.setCaifuLevel(caifu);
			userBean.setUserType(jobct.optInt("a8"));
			userBean.setRoomRoles(jobct.optString("a1").split(","));
			
			giftBean = new GiftBean();
			boolean isComboFlag = jobct.optBoolean("x");
			int isFree = jobct.optInt("y");
			boolean comboAutoSwitch = jobct.optBoolean("a");
			int comboGroupNum = jobct.optInt("b");
			int comboNum = jobct.optInt("c");
			int giftCount = jobct.optInt("i");
			int giftId = jobct.optInt("n");
			String giftName = jobct.optString("q");
			String giftIcon = jobct.optString("m");//礼物图片
			giftBean.setIsFree(isFree);
			giftBean.setGiftId(giftId);
			giftBean.setGiftName(giftName);
			giftBean.setGiftCount(giftCount);
			giftBean.setComboAutoSwitch(comboAutoSwitch);
			giftBean.setComboFlag(isComboFlag);
			giftBean.setComboGroupNum(comboGroupNum);
			giftBean.setComboNum(comboNum);
			giftBean.setGiftIcon(giftIcon);
			
			msg = " 送"+giftCount+"个 "+giftName;
			if(isComboFlag){
				msg = " 送"+comboNum+"个 x "+comboGroupNum+"组 "+ giftName;
			}
		}
	}

	public ChatUserSimpleBean getUserBean() {
		return userBean;
	}

	public GiftBean getGiftBean() {
		return giftBean;
	}

	public String getMsg() {
		return msg;
	}
	
}
