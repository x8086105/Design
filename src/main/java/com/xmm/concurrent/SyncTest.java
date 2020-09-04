package com.xmm.concurrent;

public class SyncTest {
    static int count = 0;
    static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i<5000;i++){
                    synchronized (object){
                        count++;

                    }

                }
            }
        },"t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0 ;i<5000;i++) {
                    synchronized (object) {
                        count--;
                    }
                }
            }
        },"t2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }

    public synchronized void t(){

    }
}
