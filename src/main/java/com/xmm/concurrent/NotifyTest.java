package com.xmm.concurrent;

/**
 * @Author: xuemingming
 * @Date: 2019/5/28 10:03
 **/
public class NotifyTest {
    public static void main(String[] args) {
        ShareData sd = new ShareData();
        Thread t1 = new Thread(()->{
            sd.add();
        });
//        Thread t2 = new Thread(()->{
//            try {
//                //sd.del();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        t1.start();
        //t2.start();
    }
}
