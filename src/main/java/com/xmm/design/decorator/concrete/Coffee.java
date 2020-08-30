package com.xmm.design.decorator.concrete;

import com.xmm.design.decorator.component.Drink;

public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
