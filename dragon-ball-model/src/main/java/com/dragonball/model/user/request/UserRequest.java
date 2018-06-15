package com.dragonball.model.user.request;

import com.dragonball.common.context.request.AbstractServiceRequest;

/**
 * Created by 汪先森 on 2018/6/4.
 * 用户请求
 */
public class UserRequest extends AbstractServiceRequest{

    private Long id;

    /**
     * 编号
     */
    private int num;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 第几页
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
