package com.xmm.design.strategy.service;

/**
 * 策略模式
 * @author xuemingming
 */
public interface MemberStrategy {
    /**
     * 根据原始价格 根据不同的策略（会员等级）计算出响应的价格
     */
    double calculatePrice(double price);
}
