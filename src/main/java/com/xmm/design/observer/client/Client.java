package com.xmm.design.observer.client;

import com.xmm.design.observer.obserable.ConcreteObservable;
import com.xmm.design.observer.observer.ConcreteObserver;

public class Client {
    public static void main(String[] args) {
        //创建被观察者
        ConcreteObservable concreteObservable = new ConcreteObservable();
        //创建观察者
        ConcreteObserver concreteObserver1 = new ConcreteObserver();
        ConcreteObserver concreteObserver2 = new ConcreteObserver();
        //将观察者注册进去
        concreteObservable.register(concreteObserver1);
        concreteObservable.register(concreteObserver2);
        //改变一下数据
        concreteObservable.setDate1("11");
        concreteObservable.setDate2(2);
        concreteObservable.setChange(concreteObservable);
        //移除第二个观察者;
        concreteObservable.remove(concreteObserver2);
        concreteObservable.setDate1("111");
        concreteObservable.setDate2(21);
        concreteObservable.setChange(concreteObservable);


    }
}
