package com.xmm.design.strategy.impl;

import com.xmm.design.strategy.service.MemberStrategy;

/**
 * 中级会员折扣类，会打九折
 * @author xuemingming
 */
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calculatePrice(double price) {
        System.out.println("中级会员折扣类，会打九折");
        return price*0.9;
    }
}
