package com.xmm.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xuemingming
 * @Date: 2019/5/23 18:17
 * 可以加上volatile 和去掉volatile 看看有什么区别
 * volatile 只能保证可见性，并不能保证原子性，在给其赋值的时候，不依赖当前值，可以使用
 **/
public class valotileTest {
    private static volatile int age = 0;
    private static volatile int age2 = 0;
    private static AtomicInteger ageAtomic = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 =  new Thread(() -> {
            for(int i = 0;i<10000;i++){
                ageAtomic.getAndAdd(1);
                age++;

            }
        });
        Thread thread2 =  new Thread(() -> {
            for(int i = 0;i<10000;i++){
                ageAtomic.getAndAdd(1);
                age++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(age);//age输出飘忽不定是因为volatile只能解决可见性，并不能解决原子性操作
        System.out.println(ageAtomic.get());

    }
}
