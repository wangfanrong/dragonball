package com.dragonball.model.user.response;

import com.dragonball.common.context.response.AbstractServiceResponse;
import com.dragonball.common.context.response.GenericPageResponse;
import com.dragonball.model.user.entity.UserEO;

import java.util.List;

/**
 * Created by 汪先森 on 2018/6/1.
 */
public class UserResponse extends AbstractServiceResponse{

    /**
     * 返回的列表数据
     */
    private UserEO result;
    /**
     * 返回的列表数据集合
     */
    private List<UserEO> data;
    /**
     * 分页参数
     */
    private GenericPageResponse page;

    public UserEO getResult() {
        return result;
    }

    public void setResult(UserEO result) {
        this.result = result;
    }

    public List<UserEO> getData() {
        return data;
    }

    public void setData(List<UserEO> data) {
        this.data = data;
    }

    public GenericPageResponse getPage() {
        return page;
    }

    public void setPage(GenericPageResponse page) {
        this.page = page;
    }
}
