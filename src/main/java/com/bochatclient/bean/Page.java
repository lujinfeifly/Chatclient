package com.bochatclient.bean;

public class Page {
	private int total;
	private int nextPage;//1：可翻页
	private int pageNum;//当前页数
	private int pageSize=40;//每页人数
	
	public Page(int total, int nextPage, int pageNum) {
		super();
		this.total = total;
		this.nextPage = nextPage;
		this.pageNum = pageNum;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [total=" + total + ", nextPage=" + nextPage + ", pageNum="
				+ pageNum + "]";
	}
	
}
