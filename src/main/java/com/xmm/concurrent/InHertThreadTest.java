package com.xmm.concurrent;

/**
 * @Author: xuemingming
 * @Date: 2019/5/23 16:35
 **/
public class InHertThreadTest {

    public static void main(String[] args) {
        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        //给主线程中的ThreadLocal赋值
        inheritableThreadLocal.set("main first value");
        //启动一个子线程，判断看有没有获取到主线程中的这个值
        System.out.println("main Thread First Print ThreadLocal Value:"+inheritableThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("尝试打印主线程中的ThreadLocal中的值:"+inheritableThreadLocal.get());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("third Thread :"+inheritableThreadLocal.get());
                    }
                }).start();
                //在子线程中设置ThreadLocal的值 后续要判断在主线程中看打印的是什么
                inheritableThreadLocal.set("son value");

                System.out.println("再次打印ThreadLocal中的值，可以得知获取的是子线程中的:"+inheritableThreadLocal.get());
                //睡眠10s在打印 看是不是main second value
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠10s 再次打印看是不是second value:"+inheritableThreadLocal.get());
            }
        }).start();
        //再次打印ThreadLocal中的值，用来判断是哪个线程赋予的值
        inheritableThreadLocal.set("main second value");
        System.out.println("main Thread print ThreadLocal Value:"+inheritableThreadLocal.get());
    }
}
