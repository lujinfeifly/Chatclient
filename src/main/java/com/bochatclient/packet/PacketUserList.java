package com.bochatclient.packet;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.bean.Page;
import com.bochatclient.enums.PacketTypeConstant;


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
		this.type = PacketTypeConstant.USER_LIST_MSG;
		
		JSONObject job = new JSONObject(json);
		this.retcode = Integer.parseInt(job.getString("retcode"));
		
		JSONObject msgjo = (JSONObject)job.getJSONArray("msg").get(0);
		JSONArray ctArray = msgjo.getJSONArray("ct");
		
		JSONObject ctA = (JSONObject) ctArray.get(0);
		int total = ctA.getInt("e");//房间总人数
		int nextPage = ctA.getInt("c");//是否有下一页
		int pageNum = ctA.getInt("d");//当前页数
		
		page = new Page(total, nextPage, pageNum);
		if(total>0){
			JSONObject ctB = (JSONObject) ctArray.get(1);
			JSONArray ulistArray = ctB.getJSONArray("h");//用户列表
			userList = new ArrayList<ChatUserSimpleBean>();
			
			
//			int caifuCount = ctA.getInt("b");//财富用户数
//			int normalCount = ctA.getInt("a");//普通用户数
//			int caifuPageCount = (caifuCount/page.getPageSize()+1);//财富等级的总页数
//			
//			int length = ulistArray.length();
//			if(pageNum<caifuPageCount){//
//				length = 40;
//			}
			
			for(int i=0;i<ulistArray.length();i++){
				JSONObject ujob = ulistArray.getJSONObject(i);
				
				int userId = Integer.parseInt(ujob.getString("bb"));
				int caifu = ujob.getInt("h");
				String icon = ujob.getString("j");
				boolean isMaster = ujob.getBoolean("l");
				int masterLevel = ujob.getInt("o");
				String userName = ujob.getString("p");
//				String roleId = ujob.getString("y");
				String zoneName = ujob.getString("b1");
				int fensiLevel = ujob.getInt("b3");
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
