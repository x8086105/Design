package com.xmm.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeTest {

     static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i  = 0;i<9999999;i++){
                    add();
                    //remove();
                }
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i  = 0;i<9999999;i++){
                    add();
                    //remove();
                }
            }
        },"t2").start();

    }

    public static void add(){
        list.add(1);
    }
    public static void remove(){
            list.remove(0);
    }
}
