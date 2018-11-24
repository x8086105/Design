package com.xmm.design.observer.client;

import com.xmm.design.observer.obserable.ConcreteObservable;
import com.xmm.design.observer.observer.ConcreteObserver;

public class Client {
    public static void main(String[] args) {
        //创建被观察者
        ConcreteObservable concreteObserable=new ConcreteObservable();
        //创建观察者
        ConcreteObserver concreteObserver1=new ConcreteObserver();
        ConcreteObserver concreteObserver2=new ConcreteObserver();
        //将观察者注册进去
        concreteObserable.register(concreteObserver1);
        concreteObserable.register(concreteObserver2);
        //改变一下数据
        concreteObserable.setDate1("11");
        concreteObserable.setDate2(2);
        concreteObserable.nodifyObservers(concreteObserable);
        //移除第二个观察者;
        concreteObserable.remove(concreteObserver2);
        concreteObserable.setDate1("111");
        concreteObserable.setDate2(21);
        concreteObserable.nodifyObservers(concreteObserable);


    }
}
