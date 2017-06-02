package com.bochatclient.enums;


public enum ErrorEnum {
	error_1(1,"系统异常"),
	error_2(2,"通信异常"),
	error_401001(401001,"无效参数"),
	error_401002(401002,"未登录"),
	error_401005(401005,"无效的房间ID"),
	error_401007(401007,"未得到授权"),
	error_401011(401011,"当前房间已满"),
	error_401014(401014,"当前聊天服务器没找到对应房间"),	
	error_409004(409004,"进入已被踢出的房间"),
	error_409005(409005,"踢出"),
	error_409006(409006,"阻止踢人"),
	error_402001(402001,"用户禁言"),
	error_402002(402002,"新手60秒不许发言"),
	error_402003(402003,"3秒内重复发言"),
	error_402013(402013,"10秒内重复发言"),
	error_402004(402004,"聊天内容为空"),
	error_402005(402005,"聊天内容过长"),
	error_402006(402006,"不允许发言"),	
	error_402007(402007,"聊天对象为空"),
	error_402009(402009,"找不到聊天对象"),
	error_402010(402010,"未满足设置的私聊级别"),	
	error_402011(402011,"当前房间关闭公聊"),
	error_402012(402012,"对方不允许私聊"),
	error_402014(402014,"公聊过滤"),
	error_402015(402015,"未满足设置的公聊级别"),	
	error_402016(402016,"游戏禁言");	
	
	private int key;
	private String value;
	
	ErrorEnum(int key,String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getErrorMsg(int key) {  
        for (ErrorEnum c : ErrorEnum.values()) {  
            if (c.getKey() == key) {  
                return c.getValue();
            }
        }  
        return null;  
    }

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
