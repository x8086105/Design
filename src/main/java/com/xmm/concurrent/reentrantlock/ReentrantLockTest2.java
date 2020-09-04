package com.xmm.concurrent.reentrantlock;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock可以被打断的锁
 *
 */
@Slf4j
public class ReentrantLockTest2 {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
//        while (i == 0){
//            System.out.println(Math.random() * (-30));
//            i+=0;
//        }
        System.out.println(Integer.MAX_VALUE);
        long result = (long) (Integer.MAX_VALUE + Math.random() * (100000 - Integer.MAX_VALUE));
        System.out.println(result);
        Thread t1 = new Thread(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.SECONDS.sleep(1);
                log.info("t1线程准备开始加锁");
                try {
                    reentrantLock.lockInterruptibly();

                }catch (Exception e){
                    e.printStackTrace();
                    log.info("t1现在在等待锁的过程中被打断了...");
                    return;
                }


                try {
                    log.debug("获得了锁");
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"t1");

        reentrantLock.lock();
        try {
            log.info("main获得了锁");
            t1.start();
            TimeUnit.SECONDS.sleep(2);
//            t1.interrupt();
//            log.info("t1线程被打断了");
        }finally {
            reentrantLock.unlock();
        }

    }

}
