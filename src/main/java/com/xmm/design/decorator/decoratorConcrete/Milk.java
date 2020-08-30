package com.xmm.design.decorator.decoratorConcrete;

import com.xmm.design.decorator.component.Drink;
import com.xmm.design.decorator.decorator.Decorator;

public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);

        setDesc(" 牛奶 ");
        setPrice(2.0f);
    }
}
