package com.xmm.concurrent;

/**
 * @Author: xuemingming
 * @Date: 2019/5/23 16:26
 **/
public class ThreadTest {


    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        //给主线程中的ThreadLocal赋值
        threadLocal.set("main value");
        //启动一个子线程，判断看有没有获取到主线程中的这个值
        System.out.println("main Thread First Print ThreadLocal Value:"+threadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("尝试打印主线程中的ThreadLocal中的值:"+threadLocal.get());
                //在子线程中设置ThreadLocal的值 后续要判断在主线程中看打印的是什么
                threadLocal.set("son value");
                System.out.println("再次打印ThreadLocal中的值，可以得知获取的是子线程中的:"+threadLocal.get());
            }
        }).start();
        //再次打印ThreadLocal中的值，用来判断是哪个线程赋予的值
        System.out.println("main Thread print ThreadLocal Value:"+threadLocal.get());
        /**
         * 预期结果
         * main Thread First .... : main value
         * 尝试打印主线程中的ThreadLocal中的值：null
         * 再次打印ThreadLocal中的值，可以得知获取的是子线程中的 : son value
         * main Thread print ThreadLocal Value : main value
         */
    }
}
