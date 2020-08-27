package com.xmm.design.flyweight.composite;


import com.google.common.collect.Lists;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        FlyWeightFactory factory = FlyWeightFactory.getInstance();

        List<String> keys = Lists.newArrayList("k1","k2","k3");
        FlyWeight flyWeight = factory.getFlyweight(keys);
        //这里填充外部状态
        flyWeight.operation("外部状态");


    }
}
