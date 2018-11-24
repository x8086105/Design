package com.xmm.design.strategy.impl;

import com.xmm.design.strategy.service.MemberStrategy;

/**
 * 初级会员折扣类 不打折
 * @author xuemingming
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calculatePrice(double price) {
        System.out.println("初级会员折扣类，不打折");
        return price;
    }
}
