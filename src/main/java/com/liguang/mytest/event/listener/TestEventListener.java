package com.liguang.mytest.event.listener;

import com.google.common.eventbus.Subscribe;
import com.liguang.mytest.event.TestEvent;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/6/28
 * History: //修改历史
 */

public class TestEventListener {
    public Integer lastMessage = 0;

    @Subscribe
    public void eventLister(TestEvent event) {
        System.out.println("Message:" + event.getMessage());
    }

    public Integer getLastMessage() {
        return this.lastMessage;
    }
}
