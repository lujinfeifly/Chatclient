package com.bochatclient.exception;

public class BoException extends Exception {
	
	private int code = 0;
	private String msg = "";
	
	public BoException(int i, String msg) {
		this.code = i;
		this.msg = msg;
	}

}
