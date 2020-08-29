package com.xmm.concurrent;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        testRunningInterrupt();
        //testSleepInterrupt();
    }

    /**
     * 打断睡眠中的线程
     * @throws InterruptedException
     */
    public static void testSleepInterrupt() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("sleep...");
                TimeUnit.SECONDS.sleep(5);

            }
        });
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("开始打断T1睡眠中的线程");
        //重点： 打断阻塞的线程 就会清楚标志位  sleep,wait,join
        t1.interrupt();
        System.out.println("t1线程的interrupt的标志为：" + "----" + t1.isInterrupted());
        System.out.println("t1线程的interrupt的标志为：" + "----" + t1.isInterrupted());

        TimeUnit.SECONDS.sleep(1);
        System.out.println("t1线程的interrupt的标志为：" + t1.getState() + "----"+ t1.isInterrupted());
    }
    /**
     * 打断睡眠中的线程
     * @throws InterruptedException
     */
    public static void testRunningInterrupt() throws InterruptedException {
        Thread.State s = Thread.currentThread().getState();
        System.out.println(s);
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("running...");
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        log.info("t1即将退出");
                        break;
                    }
                }

            }
        });
        t1.setName("t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        //重点： 打断运行中的线程 不会清楚标志位
        System.out.println("t1线程正在运行：" +t1.getState() + "---" +  t1.isInterrupted());
        System.out.println("给t1线程设置中断标志位");
        t1.interrupt();
        System.out.println("t1线程还没有完全退出哦：" + t1.getState()  + "---" +  t1.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("t1线程已退出");
        //因为有以上这点，所以 t1.isInterrupted返回的是false
        //这里是因为 t1线程已经退出了，所以调用isInterrupted的话 就是false了
        System.out.println("t1线程的interrupt的标志为1：" + t1.getState()  + "---" +  t1.isInterrupted());
        System.out.println("t1线程的interrupt的标志为2：" + t1.getState()  + "---" +  t1.isInterrupted());
        //设置中断标志位 但是不会真正打断线程的运行
        Thread.currentThread().interrupt();
        System.out.println("main线程的interrupt的标志为1：" + Thread.currentThread().getState() +  "---" + Thread.currentThread().isInterrupted());
        System.out.println("main线程的interrupt的标志为2：" +  Thread.currentThread().getState() + "---" + Thread.currentThread().isInterrupted());
        System.out.println("main线程的" + Thread.interrupted());
        System.out.println("main线程的" + Thread.interrupted());
        System.out.println("main线程的" + Thread.interrupted());
    }

}
/**
 *    isInterrupted不会清楚标志位
 *    但是如果线程退出之后 isInterrupted()会返回false，也就是线程状态为TERMINATED
 *    如果调用了interrupt()方法，线程状态为RUNNABLE，调用isInterrupted()为true
 *
 **/