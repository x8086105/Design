package com.xmm.concurrent.syncronized;

/**
 * 这个类主要用来看字节码
 *
 */
public class SynchronizedTest {
    /**
     * 作为一个锁
     */
    private static Object object = new Object();

    public static void main(String[] args) {

        synchronized (object){

            System.out.println("zzz");
        }
    }
}
