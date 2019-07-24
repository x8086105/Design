package com.xmm.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xuemingming
 * @Date: 2019/5/28 9:54
 **/
public class LockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition1 = reentrantLock.newCondition();
    static Condition condition2 = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                reentrantLock.lock();
                System.out.println("t1 lock,await forward");
                condition1.await();
                System.out.println("t1 lock,await after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(50);
                reentrantLock.lock();
                condition1.signal();
                System.out.println("signal t1");
                System.out.println("t2 lock,await forward");
                condition2.await();
                System.out.println("t2 lock,await after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        });
        t1.start();
        t2.start();
        Thread.sleep(100);
        System.out.println("main Thread end");

    }
}
