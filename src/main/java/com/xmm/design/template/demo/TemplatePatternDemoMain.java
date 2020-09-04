package com.xmm.design.template.demo;

public class TemplatePatternDemoMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Account moneyMarketAccout = new MoneyMarketAccount();
        Account cdAccount = new CDAccount();
        
        System.out.println("money market account interest:"+moneyMarketAccout.calculateInterest());
        System.out.println("cd account interest:"+cdAccount.calculateInterest());
    }

}