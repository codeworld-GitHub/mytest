package com.liguang.mytest.designatterns.observer;

import java.util.Vector;

/**
 * Desc: 主题接口实现
 * JDK 内部已经为开发人员准备了一套观察者模式的实现，
 *
 * @see java.util.Observable 类 和
 * @see java.util.Observer 接口
 * Auth: fairy
 * Date: 2023/4/24 10:57
 */
public class ConcreteSubject implements ISubject {
    //Vector实现了AbstractList抽象类和List接口,和ArrayList一样是基于Array存储的
    //Vector 是线程安全的,在大多数方法上存在synchronized关键字
    ////Vector存放的元素,初始化默认长度为10
    Vector<IObserver> observers = new Vector<>();

    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
        Event event = new Event();
        for (IObserver observer : observers) {
            observer.update(event); // 这里通知观察者
        }
    }
}
