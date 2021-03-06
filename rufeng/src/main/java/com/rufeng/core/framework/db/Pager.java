package com.rufeng.core.framework.db;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Pager implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer totalSize = 10;
	private Integer currentPage;
	
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	@Override
	public String toString() {
		return "Pager [totalSize=" + totalSize + ", currentPage=" + currentPage + "]";
	}
}
