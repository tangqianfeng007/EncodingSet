package com.encodingset.util;

/**
*
*@Author tangqianfeng 
*@Version 1.0
*
*/
public class PageTool {
    private int currentPage = 1;
    //总页数
    private int totalPageCount;
    //页码变化幅度
    private int cursor = 5;
    //显示页码最大量
    private int lineCursor = 10;


    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


    public PageTool() {
    }

    public String getPageStringForJsSeek(Page page) {
        this.currentPage = page.getCurrentPage();
        this.totalPageCount = page.getTotalPageCount();
        return getLeftTools2Seek() + getCenter2Seek() + getRightTools2Seek();
    }

    private String getLeftTools2Seek() {
        StringBuffer leftString;
        if (currentPage == 1) {
            leftString = new StringBuffer("");
        } else {
            leftString = new StringBuffer("<a href='javascript:;' onclick='seekByPage(1);'><font class='page_up_down'>« 首页</font></a><a href='javascript:;' onclick='seekByPage(" + (getCurrentPage() - 1) + ");'><font class='page_up_down'>上一页</font></a>");
        }
        return leftString.toString();
    }


    private String getRightTools2Seek() {
        StringBuffer rightString;
        if (currentPage == totalPageCount || totalPageCount == 0) {
            rightString = new StringBuffer("");
        } else {
            rightString = new StringBuffer("<a href='javascript:;' onclick='seekByPage(" + (getCurrentPage() + 1) + ");'><font class='page_up_down'>下一页</font></a><a href='javascript:;' onclick='seekByPage(" + (getTotalPageCount()) + ");'><font class='page_up_down'>尾页 »</font></a>");
        }
        return rightString.toString();
    }


    private String getCenter2Seek() {
        StringBuffer centerString = new StringBuffer("");
        if (totalPageCount <= lineCursor) {
            for (int i = 1; i < this.totalPageCount + 1; i++) {
                if (i == this.currentPage) {
                    centerString.append("<a href='javascript:;' class='on'><strong>" + i + "</strong></a>");
                } else {
                    centerString.append("<a href='javascript:;' onclick='seekByPage(" + i + ");'>" + i + "</a>");
                }
            }
        } else {
            int s = currentPage - cursor;
            if (s < 0) {
                for (int i = 1; i < lineCursor + 1; i++) {
                    if (i == this.currentPage) {
                        centerString.append("<a href='javascript:;' class='on'><strong>" + i + "</strong></a>");
                    } else {
                        centerString.append("<a href='javascript:;' onclick='seekByPage(" + i + ");'>" + i + "</a>");
                    }
                }
            } else {
                if (s + lineCursor > totalPageCount) {
                    for (int i = totalPageCount - lineCursor + 1; i <= totalPageCount; i++) {
                        if (i == this.currentPage) {
                            centerString.append("<a href='javascript:;' class='on'><strong>" + i + "</strong></a>");
                        } else {
                            centerString.append("<a href='javascript:;' onclick='seekByPage(" + i + ");'>" + i + "</a>");
                        }
                    }
                } else {
                    for (int i = s + 1; i < lineCursor + s + 1; i++) {
                        if (i == this.currentPage) {
                            centerString.append("<a href='javascript:;' class='on'><strong>" + i + "</strong></a>");
                        } else {
                            centerString.append("<a href='javascript:;' onclick='seekByPage(" + i + ");'>" + i + "</a>");
                        }
                    }
                }
            }
        }
        return centerString.toString();
    }
}
