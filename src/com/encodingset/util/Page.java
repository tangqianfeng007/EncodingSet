package com.encodingset.util;

import java.io.Serializable;


/**
*
*@Author tangqianfeng 
*@Version 1.0
*
*/
public class Page implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 //一页的容量
    public static int pageSize = 10;

	//目前的页数
    private int currentPage;
    //数据总量
    private int totalCount;

    public Page() {
    }


    public Page(int currentPage, int totalSize) {
        this.currentPage = currentPage;
        this.totalCount = totalSize;
    }

    public int getTotalSize() {
        return this.totalCount;
    }


    public int getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public static int getPageSize() {
		return pageSize;
	}


	public static void setPageSize(int pageSize) {
		Page.pageSize = pageSize;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}

