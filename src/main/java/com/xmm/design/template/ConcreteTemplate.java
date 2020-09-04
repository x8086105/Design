package com.xmm.design.template;

public class ConcreteTemplate extends TemplateAbstract{
    @Override
    public void abstractMethod1() {
        System.out.println("实现类实现的方法1：abstractMethod1");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("实现类实现的方法2：abstractMethod2");

    }

    @Override
    public void hoodMethod() {
        super.hoodMethod();
        System.out.println("实现了钩子方法");
    }
}
