package com.xmm.concurrent.syncronized;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程进行售票
 * Synchronized实现
 */
@Slf4j
public class SellTicketDemo3 {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        TicketWindow ticketWindow = new TicketWindow(2000);

        //用来存储开启的线程，方便后续join
        List<Thread> threadList = Lists.newArrayList();
        List<Integer> sellCount = new Vector<>();
        log.info("开始售票，票的初始总数为:{}", ticketWindow.count);

        for(int i = 0; i < 2000; i ++){
            Thread t = new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    reentrantLock.lock();
                    int count = ticketWindow.sell(randomAmount());
                    sellCount.add(count);
                }finally {
                    reentrantLock.unlock();
                }



            });
            threadList.add(t);
            t.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        log.info("售票结束，卖出的票的总数为：{}",sellCount.stream().mapToInt(c -> c).sum());
        log.info("售票结束，剩余的票的总数为：{}",ticketWindow.getCount());

    }

    // Random 为线程安全
    static Random random = new Random();
    // 随机 1~5
    public static int randomAmount() {
        return random.nextInt(5) + 1;
    }


    /**
     * 售票窗口的类
     *
     */
    static class TicketWindow {
        int count;

        public TicketWindow(int count){
            this.count = count;
        }
        public int getCount() {
            return count;
        }

        public int sell(int amount) {
            if (this.count >= amount) {
                this.count -= amount;
                return amount;
            } else {
                return 0;
            }
        }

    }
}

/**
 * 这里主要模拟1000个人，
 * 每个人买10张票
 * 每个人一个线程
 * 等线程结束之后，打印出剩余的票数
 * 理论上剩余 9000
 **/