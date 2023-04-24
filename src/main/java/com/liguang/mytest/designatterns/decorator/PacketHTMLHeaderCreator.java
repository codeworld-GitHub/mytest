package com.liguang.mytest.designatterns.decorator;

/**
 * Desc: 具体的装饰器
 * Auth: fairy
 * Date: 2023/4/24 10:18
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() { // 将给定数据封装成HTMNL
        return "<html><body>".concat(component.handleContent()).concat("</body></html>\n");
    }
}
