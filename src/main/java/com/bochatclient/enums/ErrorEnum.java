package com.bochatclient.enums;


public enum ErrorEnum {
	error_1(1,"系统异常"),
	error_2(2,"通信异常"),
	error_404(404,"连接已断开"),
	error_401001(401001,"系统异常401001"), 
	error_401002(401002,"系统异常401002"),
	error_401005(401005,"直播间不存在"),
	error_401007(401007,"您被移出直播间1小时"),
	error_401011(401011,"直播间人数达到上限"),
	error_401014(401014,"系统异常401014"),	
	error_409004(409004,"进入已被踢出的房间"),
	error_409005(409005,"系统异常409005"),
	error_409006(409006,"系统异常409006"),
	error_409007(409007,"电脑端已登录，您已被移出直播间"),
	error_402001(402001,"您被禁言30分钟"),
	error_402002(402002,"系统异常"),
	error_402003(402003,"发言间隔不足2秒"),
	error_402004(402004,"系统异常402004"),
	error_402005(402005,"系统异常402005"),
	error_402006(402006,"系统异常402006"),
	error_402007(402007,"没有选中聊天对象"),
	error_402008(402008,"系统异常402008"),
	error_402009(402009,"聊天对象已离开直播间"),
	error_402010(402010,"财富等级不足 %d 级"),	
	error_402011(402011,"直播间公聊已关闭"),
	error_402012(402012,"对方已设置拒绝私聊"),
	error_402013(402013,"发言间隔不足3秒"),
	error_402014(402014,"系统异常402014"),
	error_402015(402015,"财富等级不足 %d 级"),	
	error_402016(402016,"系统异常402016");	
	
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
