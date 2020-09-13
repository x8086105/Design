package com.xmm.concurrent.syncronized;

public class LockAllgatoring {

    private static Object object = new Object();
    private static Object object2 = new Object();

    private static int i = 0;
   static volatile int is =0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("hello1");

                    System.out.println("hello2");
                    is++;

                    System.out.println("hello3");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (is == 1) {
                    System.out.println("ssss");
                    synchronized (object){
                        System.out.println("xxxx");

                    }
                }
            }
        }).start();
    }
}
