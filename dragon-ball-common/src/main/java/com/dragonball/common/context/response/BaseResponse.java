package com.dragonball.common.context.response;

import java.util.List;

/**
 * Created by 汪先森 on 2018/6/1.
 */
public class BaseResponse<T> extends AbstractServiceResponse {

    /**
     * 返回的列表数据
     */
    private T result;
    /**
     * 返回的列表数据集合
     */
    private List<T> data;

    public BaseResponse() {
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
