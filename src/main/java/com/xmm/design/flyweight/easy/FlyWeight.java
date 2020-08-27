package com.xmm.design.flyweight.easy;

public interface FlyWeight {
    String getIntrinsicState();

    void operation(String extrinsicState);
}
