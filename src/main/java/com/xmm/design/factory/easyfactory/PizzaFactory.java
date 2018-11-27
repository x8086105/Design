package com.xmm.design.factory.easyfactory;

/**
 * 简单工厂模式工厂类
 * @author xuemingming
 */
public class PizzaFactory {
    public static Pizza getFactory(int type){
        switch (type){
            case 0:
                return new JiDanPizza();
            case 1:
                return new NiuPaiPizza();
                default:
                    System.out.println("类型异常");
                    return null;
        }
    }
}
