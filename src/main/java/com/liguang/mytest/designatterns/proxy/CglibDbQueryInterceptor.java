package com.liguang.mytest.designatterns.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Desc: Cglib 动态代理实现
 * Auth: fairy
 * Date: 2023/4/23 14:36
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor()); // 指定切入器，定义代理类逻辑
        enhancer.setInterfaces(new Class[]{IDBQuery.class}); //指定实现的接口
        return (IDBQuery) enhancer.create();
    }
}
