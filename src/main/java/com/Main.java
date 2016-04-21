package com;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.bochatclient.BoChatClient;
import com.bochatclient.URLEncode;
import com.bochatclient.UserEnterBean;
import com.bochatclient.listener.ErrorListener;
import com.bochatclient.listener.MsgListener;
import com.bochatclient.packet.PacketBase;

public class Main implements MsgListener, ErrorListener{

	public static void main(String[] args) {
		
		Main a = new Main();
		BoChatClient client = new BoChatClient("10.127.132.81", 6200);
		UserEnterBean bean = new UserEnterBean("2323", "hehe", "2200068411", "hehe");
		client.setMsgListener(a);
		client.setErrorListener(a);
		client.setLoginBean(bean);
		
		client.connect();
		client.enterroom();
		client.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
		
		client.sendMessage("ssssssssssssssssssss");

		System.out.println("Enter Ok!");
	}

	public void onError(int errorNo) {
		System.out.println("-----------------" + errorNo);
		
	}

	public void onReciveMsg(PacketBase packet) {
		System.out.println("~~~~~~~~~~~~~~~~~" + packet.toDisplayMsg());
		
	}
}