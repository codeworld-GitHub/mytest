package com.liguang.mytest.designatterns.singleton;

/**
 * Desc: 使用内部类的方式实现单例，既可以做到延迟加载，也不必使用同步关键字，是一种比较完善的实现
 * Auth: fairy
 * Date: 2023/4/23 14:02
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
