package com.xmm.concurrent;

public class Person {

    private static int age;

    public static synchronized void add(){
        age++;
    }


    public int getAge(){
       return age;
    }
}
