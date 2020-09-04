package com.xmm.design.template;

public abstract class TemplateAbstract {


    /**
     * 基本方法：顶层模版类实现的方法，子类不能更改的方法
     */
    public final void concreteMethod(){
        System.out.println("TemplateAbstract--Method: concreteMethod");
    }
    /**
     * 抽象方法：子类必须实现和替换的方法
     */
    public abstract void abstractMethod1();
    /**
     * 抽象方法：子类必须实现和替换的方法
     */
    public abstract void abstractMethod2();

    /**
     * 钩子方法：子类可以选择性的实现或者不实现的方法
     */
    public void hoodMethod() {

    }

    /**
     * 模版方法：顶层的统一实现逻辑，子类不能更改或者替换
     */
    public final void templateMethod(){
        System.out.println("顶层模板类的模板方法");
        concreteMethod();
        abstractMethod1();
        hoodMethod();
        abstractMethod2();
    }
}
