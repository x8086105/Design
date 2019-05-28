package com.xmm.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: xuemingming
 * @Date: 2019/5/28 18:15
 **/
public class LockSupportTest {
    public static void main(String[] args) {
        System.out.println("Before Lock Support park ");
        //直接阻塞线程 因为默认情况下线程是不具备持有证的

        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        //LockSupport.unpark(Thread.currentThread());
        System.out.println("After Lock Support park ");

    }
}
