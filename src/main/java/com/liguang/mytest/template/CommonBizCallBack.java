package com.liguang.mytest.template;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */

public interface CommonBizCallBack<T> {
    /**
     * 前置校验
     */
    void beforeCheck();

    /**
     * 操作逻辑
     */
    T doAction();

    /**
     * 后置操作
     */
    void afterAction(T t);

    /**
     * finally操作
     */
    void finallyAction(T t);
}
