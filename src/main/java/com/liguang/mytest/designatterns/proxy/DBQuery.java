package com.liguang.mytest.designatterns.proxy;

/**
 * Desc: 直接实现
 * Auth: fairy
 * Date: 2023/4/23 14:21
 */
public class DBQuery implements IDBQuery {
    public DBQuery() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }
}
