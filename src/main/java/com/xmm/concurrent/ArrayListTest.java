package com.xmm.concurrent;

import com.google.common.collect.Lists;

import java.util.List;

public class ArrayListTest {
    private static List<Integer> list = Lists.newArrayList();
    private static Integer count = 0;
    static Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<99999;i++){
                   // add();
                   synchronized (o){
                       count++;

                   }
                }
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<99999;i++){
                   // add();
                    synchronized (o){
                        count++;

                    }
                }
            }
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

    public static void add(){
        list.add(1);
    }
    public static void remove(){
        list.remove(0);
    }
}
