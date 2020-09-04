package com.xmm.concurrent.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试
 * 测试可重入
 * 如果是不可重入的话，就会导致自己的线程把自己锁住
 */
@Slf4j
public class ReentrantLockTest1 {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        m1();
    }

    public static void m1(){
        reentrantLock.lock();
        try {
            log.info("m1 Lock");
            TimeUnit.SECONDS.sleep(1);
            m2();
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }

    private static void m2() {
        reentrantLock.lock();
        try {
            log.info("m2 Lock");
            TimeUnit.SECONDS.sleep(1);
            m3();
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }

    }

    private static void m3() {
        reentrantLock.lock();
        try {
            log.info("m3 Lock");
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }

    }
}
