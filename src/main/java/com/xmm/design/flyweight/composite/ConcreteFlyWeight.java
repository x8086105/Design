package com.xmm.design.flyweight.composite;

import com.xmm.design.flyweight.composite.FlyWeight;

public class ConcreteFlyWeight implements FlyWeight {
    /**
     * 共享的就是这个内部状态
     */
    private String intrinsicState;

    public ConcreteFlyWeight(String intrinsicState){
        this.intrinsicState = intrinsicState;
    }


    @Override
    public void operation(String extrinsicState) {
        System.out.println(extrinsicState);
    }

}
