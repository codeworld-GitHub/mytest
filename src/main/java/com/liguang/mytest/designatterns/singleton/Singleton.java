package com.liguang.mytest.designatterns.singleton;

/**
 * Desc: 饱汉式单例
 * Auth: fairy
 * Date: 2023/4/23 11:22
 */
public class Singleton {
    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("createString in Singgleton");
    }
}
