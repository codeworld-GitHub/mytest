package com.liguang.mytest.designatterns.singleton;

import java.io.Serializable;

/**
 * Desc: 可序列化的单例，很少见 不推荐
 * Auth: fairy
 * Date: 2023/4/23 14:05
 */
public class SerSingleton implements Serializable {
    String name;

    private SerSingleton() {
        System.out.println("singgleeton is create");
        name = "SerSingleton";
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("creatring in Singleton");
    }

    // 反序列化关键
    private Object readResolve() {
        return instance;
    }
}
