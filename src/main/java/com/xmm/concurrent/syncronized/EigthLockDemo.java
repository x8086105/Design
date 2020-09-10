package com.xmm.concurrent.syncronized;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EigthLockDemo {

    private static synchronized void test1() throws InterruptedException {
        Thread.sleep(3000);
        log.info("test1....");
    }

    private static synchronized void test2()  {
        log.info("test2....");
    }

    public synchronized void test3() throws InterruptedException {
        Thread.sleep(500);
        log.info("test3....");
    }

    public synchronized void test4() throws InterruptedException {
        Thread.sleep(3000);
        log.info("test4....");
    }
    public void test5() throws InterruptedException {

        log.info("test5....");
    }


    public static void main(String[] args) throws InterruptedException {
        log.info("main....");
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                EigthLockDemo.test1();

            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                EigthLockDemo.test2();

            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                EigthLockDemo eigthLockDemo = new EigthLockDemo();
                eigthLockDemo.test3();

            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();

    }
}
