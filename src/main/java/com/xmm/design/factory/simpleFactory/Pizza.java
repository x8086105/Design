package com.xmm.design.factory.simpleFactory;

/**
 * @author xuemingming
 * 抽象类
 */
public abstract class Pizza {

    public abstract void make();

    public void cut(){
        System.out.println("统一操作切割Pizza");
    }

    public void pack(){
        System.out.println("统一操作包装Pizza");
    }
}
