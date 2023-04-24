package com.liguang.mytest.designatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Desc: JDK动态代理实现
 * Auth: fairy
 * Date: 2023/4/23 14:31
 */
public class JdkDbQueryHandler implements InvocationHandler {
    IDBQuery real = null; // 主题接口

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            real = new DBQuery(); // 如果是第一次调用则生成真实对象
        }
        return real.request(); // 使用真实主题完成实际操作
    }

    public static IDBQuery createJdkProxy() {
        return (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JdkDbQueryHandler());
    }
}
