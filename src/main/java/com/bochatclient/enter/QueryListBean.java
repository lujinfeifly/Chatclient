package com.bochatclient.enter;

public class QueryListBean implements SendBean{
//	private String rid;
//	private String uid;
	private String pno;
	private String rpp;
	private String v = "0";
	
	public QueryListBean(String rid, String uid ,String pno, String rpp) {
//		this.rid = rid;
//		this.uid = uid;
		this.pno = pno;
		this.rpp = rpp;
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

	
}
