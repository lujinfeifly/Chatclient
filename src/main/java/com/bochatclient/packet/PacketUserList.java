package com.bochatclient.packet;


import java.util.ArrayList;
import java.util.List;

import com.bochatclient.annotation.Mapping;
import com.bochatclient.bean.ChatUserListBean;
import com.bochatclient.bean.ChatUserSimpleBean;
import com.bochatclient.cache.Cache;
import com.bochatclient.cache.CacheManager;
import com.bochatclient.utils.PageUtil;


/**
 * @ClassName: PacketUserList.java
 * @Description: 观众列表返回
 * @author renms
 * @date 2017年3月9日 下午3:29:20 
 * @version 1.0
 */
public class PacketUserList extends PacketBase{

	@Mapping("e")
	private int total;
	@Mapping("c")
	private int nextPage;//1：可翻页
	@Mapping("d")
	private int pageNum;//当前页数
	
	@Mapping("b")
	private int caifuCount;
	@Mapping("a")
	private int normalCount;

	
	@Mapping(value="h",type="list",name="com.bochatclient.bean.ChatUserSimpleBean")
	private List<ChatUserSimpleBean> userList;
	
//	public PacketUserList(String json) throws Exception {
//		super();
//		this.type = PacketConstant.PacketType.USER_LIST_MSG;
//		
//		JSONObject job = new JSONObject(json);
//		this.retcode = Integer.parseInt(job.optString("retcode"));
//		
//		JSONObject msgjo = (JSONObject)job.optJSONArray("msg").opt(0);
//		JSONArray ctArray = msgjo.optJSONArray("ct");
//		
//		JSONObject ctA = (JSONObject) ctArray.opt(0);
//		int total = ctA.optInt("e");//房间总人数
//		int nextPage = ctA.optInt("c");//是否有下一页
//		int pageNum = ctA.optInt("d");//当前页数
//		
//		page = new Page(total, nextPage, pageNum);
//		if(total>0){
//			JSONObject ctB = (JSONObject) ctArray.opt(1);
//			JSONArray ulistArray = ctB.optJSONArray("h");//用户列表
//			userList = new ArrayList<ChatUserListBean>();
//			
//			
//			int caifuCount = ctA.optInt("b");//财富用户数
//			int normalCount = ctA.optInt("a");//普通用户数
//			
//			
//			int length = ulistArray.length();
//			int showSize = pageNum*page.getPageSize();//已经显示了财富用户数量
//			if(showSize<caifuCount){
//				length = 40;//财富用户数量为40
//			}else{
//				length = caifuCount-((pageNum-1)*page.getPageSize());
//			}
//			
//			List<ChatUserListBean> normalUserList = new ArrayList<ChatUserListBean>();
//			for(int i=0;i<ulistArray.length();i++){
//				JSONObject ujob = ulistArray.optJSONObject(i);
//				ChatUserListBean userBean = JSONHelper.jsonToObject(ujob, ChatUserListBean.class);
//				if(i<length){
//					userList.add(userBean);
//				}else{//普通用户
//					normalUserList.add(userBean);
//				}
//			}
//			
//			//重新加载第一页时，清除普通用户缓存
//			if(page.getPageNum()==1){
//				CacheManager.clearAll("userList_");
//			}
//			
//			CacheManager.putCacheInfo("userList_"+pageNum, normalUserList);
//
//			if(length<=0){//没有下一页，显示普通用户
//				for(int i=1;i<=pageNum;i++){
//					Cache cache = CacheManager.getCacheInfo("userList_"+i);
//					List<ChatUserListBean> list = (List<ChatUserListBean>) cache.getValue();
//					if(list!=null){
//						userList.addAll(list);
//					}
//				}
//			}
//		}
//	}

	public List<ChatUserSimpleBean> getUserList() {
		return userList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getCaifuCount() {
		return caifuCount;
	}
	public void setCaifuCount(int caifuCount) {
		this.caifuCount = caifuCount;
	}
	public int getNormalCount() {
		return normalCount;
	}
	public void setNormalCount(int normalCount) {
		this.normalCount = normalCount;
	}
	public void setUserList(List<ChatUserSimpleBean> auserList) {
		this.userList = auserList;
				
//		//对list分组处理
//		int length = auserList.size();
//		int showSize = pageNum*PageUtil.pageSize;//已经显示了财富用户数量
//		if(showSize<caifuCount){
//			length = PageUtil.pageSize;//财富用户数量为40
//		}else{
//			length = caifuCount-((pageNum-1)*PageUtil.pageSize);
//		}
//		
//		this.userList = new ArrayList<ChatUserListBean>();
//		List<ChatUserListBean> normalUserList = new ArrayList<ChatUserListBean>();
//		for(int i=0;i<auserList.size();i++){
//			ChatUserListBean userBean = auserList.get(i);
//			if(i<length){
//				this.userList.add(userBean);
//			}else{//普通用户
//				normalUserList.add(userBean);
//			}
//		}
//		
//		//重新加载第一页时，清除普通用户缓存
//		if(pageNum==1){
//			CacheManager.clearAll("userList_");
//		}
//		
//		CacheManager.putCacheInfo("userList_"+pageNum, normalUserList);
//
//		if(length<=0){//没有下一页，显示普通用户
//			for(int i=1;i<=pageNum;i++){
//				Cache cache = CacheManager.getCacheInfo("userList_"+i);
//				List<ChatUserListBean> list = (List<ChatUserListBean>) cache.getValue();
//				if(list!=null){
//					this.userList.addAll(list);
//					list.clear();//清空给客户端返回的数据
//				}
//			}
//		}
	}
	@Override
	public String toString() {
		return "PacketUserList [retcode=" + retcode + ", retmsg=" + retmsg
				+ ", type=" + type + ", version=" + version + ", total="
				+ total + ", nextPage=" + nextPage + ", pageNum=" + pageNum
				+ ", pageSize=" + PageUtil.pageSize + ", userList=" + userList + "]";
	}
}
