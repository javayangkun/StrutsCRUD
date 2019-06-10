package com.struts2crud.bean;

import java.util.List;

public class Page<T> {
	private int p;			// ��ǰҳ��
	private int rowCount;	// ������
	private int maxPage;	// ��ҳ��
	private int prev;		// ��һҳ
	private int next;		// ��һҳ
	private int startLine;	// ��ʼ��
	private int size;		// ÿҳ��ʾ����
	private int startPage;	// ��ʼҳ
	private int endPage;	// ����ҳ
	private List<T> list; 	// ��ҳ����
	
	// ������ 88  ÿҳ��ʾ5��
	public Page(int pg, int rc, int sz) {
		
		p = pg;
		rowCount = rc;
		size = sz;	
		
		maxPage = (int) Math.ceil(rowCount * 1.0 / size);
		
		// ������ҳ�����ѵ�ǰҳ���޶�����Ч��Χ��
		if(p > maxPage) p = maxPage;
		if(p < 1) p = 1;
		
		// �����ߵ������ǰҳ��һ������Ч�ģ��ٸ�����Ч�ĵ�ǰҳ��ȥ���㣬��һҳ����һҳ����ʼ��
		prev = p - 1;
		next = p + 1;
		
		/*
	    SELECT * FROM USER LIMIT (1-1)*5,5
		SELECT * FROM USER LIMIT (2-1)*5,5
		SELECT * FROM USER LIMIT (3-1)*5,5
		SELECT * FROM USER LIMIT (4-1)*5,5
		SELECT * FROM USER LIMIT (5-1)*5,5
		
		SELECT * FROM USER LIMIT (p-1)*size,size
		*/
		startLine = (p - 1) * size;
		
		if(maxPage < 10) {
			startPage  =1;
			endPage = maxPage;
		} else {
			startPage = p - 5;
			endPage = p + 4;
			
			if(startPage < 1) {
				startPage = 1;
				endPage = 10;
			}
			
			if(endPage > maxPage) {
				startPage = maxPage - 9;
				endPage = maxPage;
			}
		}
		
	}
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
