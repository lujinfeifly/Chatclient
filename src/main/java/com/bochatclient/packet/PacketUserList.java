package com.bochatclient.packet;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.Page;
import com.bochatclient.enums.PacketConstant;


/**
 * @ClassName: PacketUserList.java
 * @Description: 用户列表返回
 * @author renms
 * @date 2017年3月9日 下午3:29:20 
 * @version 1.0
 */
public class PacketUserList extends PacketBase{

	Map<Integer,List<ChatUserSimpleBean>> cacheUser;
	
	private Page page;
	private List<ChatUserSimpleBean> userList;
	
	public PacketUserList(String json) throws Exception {
		super();
		this.type = PacketConstant.PacketType.USER_LIST_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.optString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
		JSONArray ctArray = msgjo.optJSONArray("ct");
		
		JSONObject ctA = (JSONObject) ctArray.opt(0);
		int total = ctA.optInt("e");//房间总人数
		int nextPage = ctA.optInt("c");//是否有下一页
		int pageNum = ctA.optInt("d");//当前页数
		
		page = new Page(total, nextPage, pageNum);
		if(total>0){
			JSONObject ctB = (JSONObject) ctArray.opt(1);
			JSONArray ulistArray = ctB.optJSONArray("h");//用户列表
			userList = new ArrayList<ChatUserSimpleBean>();
			
			
//			int caifuCount = ctA.optInt("b");//财富用户数
//			int normalCount = ctA.optInt("a");//普通用户数
//			int caifuPageCount = (caifuCount/page.optPageSize()+1);//财富等级的总页数
//			
//			int length = ulistArray.length();
//			if(pageNum<caifuPageCount){//
//				length = 40;
//			}
			
			for(int i=0;i<ulistArray.length();i++){
				JSONObject ujob = ulistArray.optJSONObject(i);
				
				int userId = Integer.parseInt(ujob.optString("bb"));
				int caifu = ujob.optInt("h");
				String icon = ujob.optString("j");
				boolean isMaster = ujob.optBoolean("l");
				int masterLevel = ujob.optInt("o");
				String userName = ujob.optString("p");
//				String roleId = ujob.optString("y");
				String zoneName = ujob.optString("b1");
				int fensiLevel = ujob.optInt("b3");
				ChatUserSimpleBean userBean = new ChatUserSimpleBean();
				
				userBean.setUserId(userId);
				userBean.setCaifuLevel(caifu);
				userBean.setIcon(icon);
				userBean.setMaster(isMaster);
				userBean.setMasterLevel(masterLevel);
				userBean.setUserName(userName);
//				userBean.setRoleId(roleId);
				userBean.setZoneName(zoneName);
				userBean.setFensiLevel(fensiLevel);
				userList.add(userBean);
			}
		}
	}

	public Page getPage() {
		return page;
	}

	public List<ChatUserSimpleBean> getUserList() {
		return userList;
	}

	@Override
	public String toString() {
		return "PacketUserList [type=" + type + ", page=" + page + ", userList=" + userList
				+ ", retcode=" + retcode + "]";
	}
	
	
	
}
