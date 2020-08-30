package com.xmm.design.decorator.decoratorConcrete;

import com.xmm.design.decorator.concrete.Coffee;

public class Espresso extends Coffee {

    public Espresso(){
        setDesc(" 意大利咖啡 ");
        setPrice(6.0f);
    }

}
