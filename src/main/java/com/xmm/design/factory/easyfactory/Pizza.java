package com.xmm.design.factory.easyfactory;

/**
 * @author xuemingming
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
