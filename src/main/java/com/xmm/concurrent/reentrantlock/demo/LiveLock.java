package com.xmm.concurrent.reentrantlock.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 活锁
 */
@Slf4j
public class LiveLock {
    static volatile int count = 10;
    static Object object = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        count --;
                        log.info("count:" + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 20){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        count ++;
                        log.info("count:" + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t2").start();

    }

    public static void add(){
        synchronized (object){
            count ++;

        }
    }
    public static void del(){
        synchronized (object){
            count --;

        }
    }
}
