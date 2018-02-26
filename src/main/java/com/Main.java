package com;

import org.json.JSONObject;

import com.bochatclient.BoChat;
import com.bochatclient.BoChatClient;
import com.bochatclient.enter.UserEnterBean;
import com.bochatclient.listener.ErrorListener;
import com.bochatclient.listener.MsgListener;
import com.bochatclient.packet.PacketBase;

public class Main implements MsgListener, ErrorListener{

	BoChat client = null;
	public void start(){
		Main a = new Main();
		try{
			client = new BoChat("182.254.159.138", 6200);
	    	client.start();//开始连接
	    	client.setMsgListener(a);
			client.setErrorListener(a);
			UserEnterBean bean = new UserEnterBean("2323", "hehe", "2200017102", "我是谁");
	    	client.enterroom(bean);//进入直播间
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void stop(){
//		client.close(true);
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.start();
    	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		JSONObject job = new JSONObject();
		job.put("renms", "123");

		int name = job.optInt("age");
		System.out.println(name);
		
//		main.client.sendQueryUserInfo("123");
//		main.client.sendMessage("ssssssssssssssssssss",0,"","");
//		main.client.sendQueryList("1", "20", "1");
		
		
//		client.sendQueryUserMsg("672030622");
    	
//        while (client.hasWriteTask()) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        while (client.getRecive() != 500) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
		
		
		
//		Main a = new Main();
//		BoChatClient client = new BoChatClient("182.254.159.138", 6200);
//		UserEnterBean bean = new UserEnterBean("2323", "hehe", "2200012003", "我是谁");
//		client.setMsgListener(a);
//		client.setErrorListener(a);
//		client.setLoginBean(bean);
//		
//		client.connect();
//		client.enterroom();
//		client.start();
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//		}
//
//		client.sendMessage("ssssssssssssssssssss",0,"","");
////		client.sendQueryList("1", "40");
//		client.sendQueryUserMsg("672030622");
//		System.out.println("Enter Ok!");
	}

	public void onError(int errorNo,String errorMsg) {
		System.out.println(errorNo+"-----------------" + errorMsg);
		
	}

	public void onReciveMsg(PacketBase packet) {
		System.out.println("packet -------------- "+packet.toString());
		
		//System.out.println("~~~~~~~~~~~~~~~~~" + packet.toDisplayMsg());
	}
}
