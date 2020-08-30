package com.xmm.design.flyweight.easy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightFactory {
    //定义一个HashMap用于存储享元对象，实现享元池
    private static final Map<String, FlyWeight> FLYWEIGHTS = new ConcurrentHashMap();
    private static final FlyweightFactory INSTANCE = new FlyweightFactory();

    private FlyweightFactory(){}

    public static FlyweightFactory getInstance(){
        return INSTANCE;
    }

    public FlyWeight getFlyweight(String key){
        //如果对象存在，则直接从享元池获取
        if (FLYWEIGHTS.containsKey(key)){
            return FLYWEIGHTS.get(key);
        }else {
            //如果对象不存在，先创建一个新的对象添加到享元池中，然后返回
            FlyWeight flyweight = new ConcreteFlyWeight("intrinsicState");
            FLYWEIGHTS.put(key, flyweight);
            return flyweight;
        }
    }

    public int getSize(){
        return FLYWEIGHTS.size();
    }
}