package com.xmm.design.decorator.concrete;

import com.xmm.design.decorator.component.Drink;

/**
 * 单体coffee ，什么都不加的coffee 被装饰者类
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
