package com.xmm.design.observer.obserable;

import com.xmm.design.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * 主题类
 * 也就是被观察者
 * @author xuemingming
 */
public abstract class BaseObservable {
    /**
     * 用来存放观察者的集合
     */
    private static List<Observer> observers=new ArrayList<>();

    /**
     * 注册观察者
     * @param o
     */
    public void register(Observer o){
        observers.add(o);
    }

    /**
     * 移除观察者
     * @param o
     */
    public void remove(Observer o){
        observers.remove(o);
    }

    /**
     * 通知观察者
     */
    public void nodifyObservers(BaseObservable obserable){
        observers.forEach(o->{
            o.update(obserable);
        });
    }
}
