package com.xmm.design.factory.easyfactory;

public class Client {
    public static void main(String[] args) {
        Pizza pizza=PizzaFactory.getFactory(0);
        pizza.cut();
        pizza.make();
        pizza.pack();
        Pizza pizza1=PizzaFactory.getFactory(1);
        pizza1.cut();
        pizza1.make();
        pizza1.pack();
    }
}
