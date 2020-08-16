package com.xmm.design.singleton;

/**
 * 懒汉式单例模式
 */
public class Singleton2 {
    private static Singleton2 singleton2 = null;
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                    return singleton2;
                }
            }
        }
        return singleton2;
    }
}
