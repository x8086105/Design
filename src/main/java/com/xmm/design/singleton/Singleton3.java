package com.xmm.design.singleton;

/**
 * 采用内部静态类的懒汉式
 */
public class Singleton3 {
    /**
     * 私有化构造函数
     */
    private Singleton3(){

    }

    /**
     * 内部静态类实现
     */
    private static class InnerClassSingletonInstance{

        private static final Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return InnerClassSingletonInstance.singleton3;
    }

}
