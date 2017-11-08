package com.bochatclient.enter;

public class QueryListBean extends SendBean{
	private String pno;
	private String rpp;
	private String uType;
	
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

	public String getUType() {
		return uType;
	}
	
}
