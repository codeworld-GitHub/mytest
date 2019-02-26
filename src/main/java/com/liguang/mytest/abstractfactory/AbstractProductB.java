package com.liguang.mytest.abstractfactory;

/**
 * @author liguang
 * @Description do something here
 * @date 2018年11月07日 下午7:44
 */
public abstract class AbstractProductB {
    //每个产品共有的方法
    public void shareMethod(){}
    //每个产品相同方法不同实现
    public abstract void doSomeThing();
}
