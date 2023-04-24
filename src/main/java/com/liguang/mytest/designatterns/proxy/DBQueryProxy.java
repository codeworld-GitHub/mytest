package com.liguang.mytest.designatterns.proxy;

/**
 * Desc: 静态代理类用于实现延迟加载
 * Auth: fairy
 * Date: 2023/4/23 14:23
 */
public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy();
        q.request();
    }
}
