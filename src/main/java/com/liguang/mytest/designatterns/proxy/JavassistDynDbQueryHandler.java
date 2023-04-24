package com.liguang.mytest.designatterns.proxy;

import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * Desc: Javassist动态代理，与静态代理相比，动态代理可以很大幅度的减少代码行数，并提升该系统的灵活性
 * Auth: fairy
 * Date: 2023/4/23 14:41
 */
public class JavassistDynDbQueryHandler implements MethodHandler {
    IDBQuery real = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    //(代理工厂模式)
    public static IDBQuery createJavassistDynProxy() throws InstantiationException, IllegalAccessException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class}); // 指定接口
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        ((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler()); // 设置handler 处理器
        return javassistProxy;
    }

    //(字节码模式)
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws InstantiationException, IllegalAccessException, CannotCompileException, NotFoundException {
        ClassPool mPool = new ClassPool(true);
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "JavassistBytecodeProxy");
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + "real", mCtc));
        String dbqueryname = DBQuery.class.getName();
        mCtc.addMethod(CtNewMethod.make("public String rquest() { if(real == null){real = new " + dbqueryname + "();} return real.request();}", mCtc));
        Class pc = mCtc.toClass();
        return (IDBQuery) pc.newInstance();
    }
}
