package com.yao.util;

public class PageUtil {
	private int pagesize=5;//每页显示的条数=5
	private int allsize;//总共的条数
	private int last;//
	private int first;//
	private int currentpage;//当前页面
	private int lastPage;//最后一页
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	/* 1  1-5
	 * 2  6-10
	 * 3  11-15    
	  */
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getAllsize() {
		return allsize;
	}
	public void setAllsize(int allsize) {
		this.allsize = allsize;
		this.lastPage=(int) Math.ceil((double)allsize/pagesize);//得到最后页
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage=currentpage;
		this.lastPage=(int) Math.ceil((double)allsize/pagesize);//得到最后页
		if(currentpage>lastPage)//如果当前页大于最后页
			this.currentpage=lastPage;
		if(currentpage<1)//如果当前页小于1
			this.currentpage=1;
		this.first=(this.currentpage-1)*this.pagesize+1;
		this.last=this.currentpage*this.pagesize;
	}
	
}
