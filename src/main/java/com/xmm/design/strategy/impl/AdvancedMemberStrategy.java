package com.xmm.design.strategy.impl;

import com.xmm.design.strategy.service.MemberStrategy;

/**
 * 高级会员折扣类
 * @author xuemingming
 */
public class AdvancedMemberStrategy implements MemberStrategy {
    /**
     * 高级会员折扣类，回打8折
     * @param price
     * @return
     */
    @Override
    public double calculatePrice(double price) {
        System.out.println("对于高级会员折扣类，会打8折");
        return price*0.8;
    }
}
