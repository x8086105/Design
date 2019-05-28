package com.xmm.concurrent;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xuemingming
 * @Date: 2019/5/28 10:07
 **/
public class ShareData {
    private Integer num = new Integer(0);
    private Integer maxSize = 10;
    private Queue queue = new PriorityQueue();
    public void add(){
        synchronized (ShareData.this){
            while (num >= maxSize){
                try {
                    ShareData.this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //num ++ ;
            num = num + 1;
            System.out.println("add : "+num);
            ShareData.this.notify();
        }
    }
//    public void del() throws InterruptedException {
//        synchronized (num){
//            while (num == 0){
//                num.wait();
//            }
//            num -- ;
//            System.out.println("del :" + num);
//            num.notify();
//        }
//    }
}
