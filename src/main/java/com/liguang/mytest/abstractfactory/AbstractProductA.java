package com.liguang.mytest.abstractfactory;

/**
 * @author OF3096
 * @version V1.0
 * @Description do something here
 * @date 2018年11月07日 下午7:38
 */
public abstract class AbstractProductA {
    //每个产品共有的方法
    public void shareMethod(){}
    //每个产品相同方法不同实现
    public abstract void doSomeThing();
}
