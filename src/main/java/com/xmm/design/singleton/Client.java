package com.xmm.design.singleton;

public class Client {
    public static void main(String[] args) {
        Singleton1 s1=Singleton1.getInstance();
        Singleton1 s11=Singleton1.getInstance();
        System.out.println(s1==s11);

        Singleton2 s2=Singleton2.getInstance();
        Singleton2 s22=Singleton2.getInstance();
        System.out.println(s2==s22);
    }
}
