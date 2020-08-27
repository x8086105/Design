package com.xmm.design.flyweight.easy;

public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory  = FlyweightFactory.getInstance();
        factory.getFlyweight("test1");
        factory.getFlyweight("test2");
        System.out.println("当前有" + factory.getSize() + "个对象");
        factory.getFlyweight("test2");
        factory.getFlyweight("test3");

        FlyWeight flyWeight = factory.getFlyweight("test1");
        flyWeight.operation("外部状态1");
        FlyWeight flyWeight2 = factory.getFlyweight("test2");
        flyWeight2.operation("外部状态2");
        System.out.println("当前有" + factory.getSize() + "个对象");
    }
}
