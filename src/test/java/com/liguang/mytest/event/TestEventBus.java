package com.liguang.mytest.event;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.liguang.mytest.event.listener.TestEventListener;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/6/28
 * History: //修改历史
 */

public class TestEventBus {
    @Test
    public void testReceiveEvent() {
        EventBus eventBus = new EventBus("test");
        TestEventListener listener = new TestEventListener();
        eventBus.register(listener);
        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(400));
        eventBus.post(new TestEvent(600));

        System.out.println("LastMessage:" + listener.getLastMessage());
    }

    @Test
    public void testReal() {
        List<String> objects = Lists.newArrayList();
        Boolean real = this.getReal(objects);
        System.out.println(objects);
    }

    private Boolean getReal(List<String> list) {
        for (int i = 0; i < 10; i++) {
            list.add(" " + i);
        }
        list.addAll(Lists.newArrayList("1", "2"));
        return true;
    }

    @Test
    public void testStream(){
        List<String> ss = Lists.newArrayList();
        List<String> collect = ss.stream().filter(StringUtils::isBlank).collect(Collectors.toList());
        System.out.println(collect);

    }

}
