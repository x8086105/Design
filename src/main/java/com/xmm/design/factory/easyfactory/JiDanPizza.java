package com.xmm.design.factory.easyfactory;

/**
 * @author xuemingming
 */
public class JiDanPizza extends Pizza {
    @Override
    public void make() {
        System.out.println("这是特有的鸡蛋Pizza的做法");
    }
}
