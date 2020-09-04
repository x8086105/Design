package com.xmm.concurrent.reentrantlock.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家就餐问题，死锁
 */
@Slf4j
public class Philosopher implements Runnable{

    private String name;

    private Chopstick left;

    private Chopstick right;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public Philosopher(String name,Chopstick left, Chopstick right){
        this.name = name;
        this.left = left;
        this.right = right;
    }
    @Override
    public void run() {
        //上锁开始吃饭
        //dieLock();
        lock();

    }
    private  void dieLock(){
        while (true){
            synchronized (left){
                synchronized (right){
                    eat();
                }
            }

        }
    }

    public  void lock(){
        while (true){
            if(left.tryLock()){
                try {
                    if(right.tryLock()){
                        try {
                            eat();
                        }finally {
                            right.unlock();
                        }
                    }
                }finally {
                    left.unlock();
                }
            }



        }
    }


    public void eat(){
        log.info(name + "开始吃饭饭");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //筷子类
    static class Chopstick extends ReentrantLock{

        String name;
        public Chopstick(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Chopstick{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
