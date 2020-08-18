package com.xmm.design.strategy.context;

import com.xmm.design.strategy.service.MemberStrategy;

/**
 * 环境类 持有一个具体的策略对象
 * @author xuemingming
 */
public class MemberPrice {
    /**
     * 持有一个memberPrice
     */
    private MemberStrategy memberStrategy;

    /**
     * 含有一个策略的构造函数
     * @param memberStrategy
     */
    public MemberPrice(MemberStrategy memberStrategy){
        this.memberStrategy = memberStrategy;
    }

    /**
     * 写一个方法 让接口调用具体方法。
     * @param price
     * @return
     */
    public double calculatePrice(double price){
        return this.memberStrategy.calculatePrice(price);
    }

}
