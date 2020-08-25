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

    public String getDesc(){
        return desc + ":" + price;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    /**
     * 需要被实现的抽象方法，花费了多少
     * @return
     */
    public abstract float cost();
}
