package com.liguang.mytest.event;

import com.google.common.eventbus.EventBus;
import com.liguang.mytest.BaseTest;
import com.liguang.mytest.event.listener.MultipleListener;
import org.junit.Test;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/6/28
 * History: //修改历史
 */

public class TestMultipleEvents extends BaseTest {
    @Test
    public void testMultipleEvents() throws Exception {

        EventBus eventBus = new EventBus("test");
        MultipleListener multiListener = new MultipleListener();

        eventBus.register(multiListener);

        eventBus.post(100);
        eventBus.post(200);
        eventBus.post(300);
        eventBus.post(800L);
        eventBus.post(800990L);
        eventBus.post(800882934L);

        System.out.println("LastInteger:" + multiListener.getLastInteger());
        System.out.println("LastLong:" + multiListener.getLastLong());
    }
}
