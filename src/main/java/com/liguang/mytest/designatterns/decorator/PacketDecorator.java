package com.liguang.mytest.designatterns.decorator;

/**
 * Desc: 维护核心组件coomponent对象
 * Auth: fairy
 * Date: 2023/4/24 10:16
 */
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;

    public PacketDecorator(IPacketCreator component) {
        this.component = component;
    }
}
