package com.liguang.mytest.designatterns.singleton;

/**
 * Desc: 懒加载单例
 * Auth: fairy
 * Date: 2023/4/23 11:26
 */
public class LazySingleton {
    private LazySingleton() {
    }
    public static LazySingleton instance = null;
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
