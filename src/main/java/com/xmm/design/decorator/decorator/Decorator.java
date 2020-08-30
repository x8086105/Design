package com.xmm.design.decorator.decorator;

import com.xmm.design.decorator.component.Drink;

/**
 * 装饰者类
 */
public class Decorator extends Drink {

    public Drink drink;

    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDesc() {
        return desc + ": " + getPrice() +" && " + drink.getDesc();
    }
}
