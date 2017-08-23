package com.bochatclient.enter;

public class QueryListBean implements SendBean{
	private String pno;
	private String rpp;
	private String uType;
	private String v = "0";
	
	public QueryListBean(String pno, String rpp, String uType) {
		this.pno = pno;
		this.rpp = rpp;
		this.uType = uType;
	}

	public String getPno() {
		return pno;
	}

	public String getRpp() {
		return rpp;
	}

	public String getV() {
		return v;
	}

	public String getUType() {
		return uType;
	}
	
}
