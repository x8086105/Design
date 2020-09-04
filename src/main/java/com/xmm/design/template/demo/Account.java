package com.xmm.design.template.demo;

public abstract class Account {
    
    /**
     * 模版方法：计算利息
     */
    public double calculateInterest() {
        double rate = getRate();
        String name = getName();
        double ammount = getAmmount(name);
        double interest = ammount * rate;
        return interest;
    }
    
    /**
     * 抽象方法：由子类实现，返回不同账户的利率
     */
    public abstract double getRate();

    /**
     * 抽象方法：由子类实现，返回账户的名称
     */
    public abstract String getName();
    
    /**
     * 基本方法：由顶层模版类自己实现，子类不可重写，计算账户余额
     * @param name：账户名称
     * @return：
     */
    public double getAmmount(String name) {
        //还需要利用其他方法，最后计算出账户目前的余额，这里省略
        return 10.11;
    }
}