package com.xmm.design.flyweight.composite;

import com.xmm.design.flyweight.easy.FlyweightFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyWeightFactory {
    //定义一个HashMap用于存储享元对象，实现享元池
    private static final Map<String, FlyWeight> FLYWEIGHTS = new ConcurrentHashMap();
    private static final FlyWeightFactory INSTANCE = new FlyWeightFactory();

    private FlyWeightFactory(){}

    public static FlyWeightFactory getInstance(){
        return INSTANCE;
    }

    // 创建"复合享元"的工厂方法
    public FlyWeight getFlyweight(List<String> keys){
        CompositeConcreteFlyweight compositeFly = new CompositeConcreteFlyweight();
        int length = keys.size();
        String key = null;
        for (int i=0; i<length; i++) {
            key = keys.get(i);
            //调用"单纯享元"的工厂方法
            compositeFly.add(this.getFlyweight(key));
        }

        return compositeFly;
    }

    // 创建"单纯享元"的工厂方法
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
}