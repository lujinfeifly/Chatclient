package com;

import com.bochatclient.BoChat;
import com.bochatclient.enter.UserEnterBean;
import com.bochatclient.listener.ErrorListener;
import com.bochatclient.listener.MsgListener;
import com.bochatclient.packet.PacketBase;

public class Main implements MsgListener, ErrorListener{

	public static void main(String[] args) {
		
		Main a = new Main();
		BoChat client = new BoChat("10.127.129.120", 6200);
    	client.start();//开始连接
    	client.setMsgListener(a);
		client.setErrorListener(a);
		UserEnterBean bean = new UserEnterBean("2323", "hehe", "2200066126", "我是谁");
    	client.enterroom(bean);//进入直播间
    	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
		client.sendMessage("ssssssssssssssssssss",0,"","");
		client.sendQueryList("1", "40");
		client.sendQueryUserMsg("672030622");
    	
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
		
		
//		
//		Main a = new Main();
//		BoChatClient client = new BoChatClient("10.127.129.120", 6200);
//		UserEnterBean bean = new UserEnterBean("2323", "hehe", "2200066126", "我是谁");
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

//		client.sendMessage("ssssssssssssssssssss",0,"","");
//		client.sendQueryList("1", "40");
//		client.sendQueryUserMsg("672030622");

		System.out.println("Enter Ok!");
	}

	public void onError(int errorNo) {
		System.out.println("-----------------" + errorNo);
		
	}

	public void onReciveMsg(PacketBase packet) {
		System.out.println("packet -------------- "+packet.toString());
		
		//System.out.println("~~~~~~~~~~~~~~~~~" + packet.toDisplayMsg());
	}
}
