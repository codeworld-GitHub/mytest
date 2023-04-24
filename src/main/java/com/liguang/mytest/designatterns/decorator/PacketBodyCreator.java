package com.liguang.mytest.designatterns.decorator;

/**
 * Desc: 具体的组件
 * Auth: fairy
 * Date: 2023/4/24 10:14
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "Content of Packet"; // 构造核心数据，但不包括格式
    }
}
