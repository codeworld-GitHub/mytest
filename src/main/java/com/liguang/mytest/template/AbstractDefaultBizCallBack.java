package com.liguang.mytest.template;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */

public class AbstractDefaultBizCallBack<T> implements CommonBizCallBack<T> {
    @Override
    public void beforeCheck() {

    }

    @Override
    public T doAction() {
        return null;
    }

    @Override
    public void afterAction(T t) {

    }

    @Override
    public void finallyAction(T t) {

    }
}
