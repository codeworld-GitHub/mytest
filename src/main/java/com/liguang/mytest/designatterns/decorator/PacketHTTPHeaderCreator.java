package com.liguang.mytest.designatterns.decorator;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 10:21
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() { // 对给定数据加上HTTP头信息
        return "Cache-Control:no-cache\nDate:Mon,31Dec201204:25:57GMT\n".concat(component.handleContent());
    }
}
