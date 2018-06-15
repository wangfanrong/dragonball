package com.dragonball.common.context.response;

import com.dragonball.common.model.GenericPage;

/**
 * Created by 汪先森 on 2018/6/14.
 */
public class GenericPageResponse {

    /**
     * 总页数
     */
    private long totalPageCount;
    /**
     * 当前页码
     */
    private long currentPageNum;
    /**
     * 当前页数据Size
     */
    private int dataSizeOfCurrentPage;
    /**
     * 是否有下一页
     */
    private boolean isHasNextPage;
    /**
     * 是否有上一页
     */
    private boolean isHasPreviousPage;
    /**
     *每页条数
     */
    private long pageSize;
    /**
     *总条数
     */
    private long totalCount;

    public long getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(long totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public long getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(long currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getDataSizeOfCurrentPage() {
        return dataSizeOfCurrentPage;
    }

    public void setDataSizeOfCurrentPage(int dataSizeOfCurrentPage) {
        this.dataSizeOfCurrentPage = dataSizeOfCurrentPage;
    }

    public boolean isHasNextPage() {
        return isHasNextPage;
    }

    public void setIsHasNextPage(boolean isHasNextPage) {
        this.isHasNextPage = isHasNextPage;
    }

    public boolean isHasPreviousPage() {
        return isHasPreviousPage;
    }

    public void setIsHasPreviousPage(boolean isHasPreviousPage) {
        this.isHasPreviousPage = isHasPreviousPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }


    /**
     * 通过参数构造分页对象
     * @param genericPage
     */
    public GenericPageResponse(GenericPage genericPage) {
        this.setTotalPageCount(genericPage.getTotalPageCount());
        this.setCurrentPageNum(genericPage.getCurrentPageNo());
        this.setIsHasNextPage(genericPage.isHasNextPage());
        this.setIsHasPreviousPage(genericPage.isHasPreviousPage());
        this.setDataSizeOfCurrentPage(genericPage.getDataSizeOfCurrentPage());
        this.setPageSize(genericPage.getPageSize());
        this.setTotalCount(genericPage.getTotalCount());
    }
}