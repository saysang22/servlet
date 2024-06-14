package org.big.entity;

import java.util.ArrayList;

public class PageTo {
	
	private ArrayList<BoardDto> list; 
	private int curPage; //현재 페이지
	private int perPage = 10; //페이지당 몇개의 레코드를 보여줄 것인지
	private int totalCount; //전체 레코드 갯수
	
	
	public ArrayList<BoardDto> getList() {
		return list;
	}
	public void setList(ArrayList<BoardDto> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
