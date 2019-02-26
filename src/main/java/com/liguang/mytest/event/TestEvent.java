package com.liguang.mytest.event;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/6/28
 * History: //修改历史
 */

public class TestEvent {
    private final Integer message;

    TestEvent(Integer message) {
        this.message = message;
        System.out.println("event message :" + message);
    }

    public Integer getMessage() {
        return this.message;
    }
}
