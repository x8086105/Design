package com.xmm.design.decorator.component;

public abstract class Drink {
    /**
     * 描述
     */
    public String desc;
    /**
     * 价格
     */
    private float price = 0.0f;

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    /**
     * 计算他的话费价格，这个方法会被子类给实现
     * @return
     */
    public abstract float cost();
}
