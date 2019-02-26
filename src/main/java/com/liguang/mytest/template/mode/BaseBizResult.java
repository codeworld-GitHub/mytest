package com.liguang.mytest.template.mode;

import lombok.Data;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */
@Data
public class BaseBizResult<T> {
    private int success; //0成功 1 失败
    private String errCode;
    private String errMsg;

    private T data;

    public static <T> BaseBizResult<T> create() {
        return new BaseBizResult<>();
    }

    public Boolean isSuccess() {
        return this.success == 0;
    }

    public BaseBizResult<T> success(Integer success) {
        this.success = success;
        return this;
    }

    public BaseBizResult<T> errCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public BaseBizResult<T> errMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public BaseBizResult<T> data(T data) {
        this.data = data;
        return this;
    }
}
