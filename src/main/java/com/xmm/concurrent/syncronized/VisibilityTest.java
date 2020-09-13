package com.xmm.concurrent.syncronized;

import java.util.concurrent.TimeUnit;

public class VisibilityTest {

    public static Object o = new Object();
    public static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    synchronized (o){

                    }
                  //  System.out.println("子线程运行。。。");

                }

            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                flag = false;
            }
        }).start();

        System.out.println("主线程运行结束");
    }
}


/**
 * JMM中关于synchronized有如下规定，线程加锁时，必须清空工作内存中共享变量的值，
 * 从而使用共享变量时需要从主内存重新读取；线程在解锁时，需要把工作内存中最新的共享变量的值写入到主存，
 * 以此来保证共享变量的可见性。(ps这里是个泛指，不是说只有在退出synchronized时才同步变量到主存)
 *
 */
