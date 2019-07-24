package com.xmm.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: xuemingming
 * @Date: 2019/5/28 18:15
 **/
public class LockSupportTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 thread begin park");
            LockSupport.park();
            System.out.println("t1 thread end park");
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println("main Tread run");
        Thread.sleep(1000);
        LockSupport.unpark(t1);
    }
}
