package com.liguang.mytest.designatterns.observer;

/**
 * Desc: 主题接口
 * Auth: fairy
 * Date: 2023/4/24 10:54
 */
public interface ISubject {
    void attach(IObserver observer); // 添加观察者

    void detach(IObserver observer); // 删除观察者

    void inform(); // 通知所有观察者
}
