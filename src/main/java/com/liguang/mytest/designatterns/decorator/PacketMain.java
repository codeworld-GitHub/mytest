package com.liguang.mytest.designatterns.decorator;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Desc: 享元模式
 * Auth: fairy
 * Date: 2023/4/24 10:23
 */
public class PacketMain {
    public static void main(String[] args) throws IOException {
        PacketHTTPHeaderCreator pc = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(pc.handleContent());

        // JDK 中 OutputStream 和 InputStream 类族的实现是装饰器模式的典型应用，通过嵌套的方式不断地将对象聚合起来，最终形成一个超级对象，并使之拥有所有相关子对象的功能。
        // 生成一个有缓冲功能的流对象
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/data/a.text")));
        // 没有缓冲功能的流对象
        DataOutputStream dout2 = new DataOutputStream(new FileOutputStream("/data/a.text"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            dout.writeLong(i);
        }
        System.out.println("speed:" + (System.currentTimeMillis() - begin));
    }
}
