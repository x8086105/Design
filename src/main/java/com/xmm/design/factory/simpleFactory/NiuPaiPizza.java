package com.xmm.design.factory.simpleFactory;

/**
 * @author xuemingming
 */
public class NiuPaiPizza extends Pizza {
    @Override
    public void make() {
        System.out.println("这是特有的牛排披萨的做法");
    }
}
