package com.xmm.concurrent.sync;

import com.xmm.design.prototype.deepclone.Person;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntUnaryOperator;

/**
 * 轻量级锁测试
 * 发生的情况是多个线程持有锁，但是没有发生竞争
 */
public class SyncTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object a = new Object();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
                try {
                    //thread1退出同步代码块，且没有死亡
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        thread1.start();

        //让thread1执行完同步代码块中方法。
        Thread.sleep(3000);
        thread2.start();
    }




}
