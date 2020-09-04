package com.xmm.concurrent.reentrantlock.demo;

public class Client {

    public static void main(String[] args) {
        Philosopher.Chopstick c1 = new Philosopher.Chopstick("1");
        Philosopher.Chopstick c2 = new Philosopher.Chopstick("2");
        Philosopher.Chopstick c3 = new Philosopher.Chopstick("3");
        Philosopher.Chopstick c4 = new Philosopher.Chopstick("4");
        Philosopher.Chopstick c5 = new Philosopher.Chopstick("5");


        new Thread(new Philosopher("亚里士多德",c1,c2),"亚里士多德").start();
        new Thread(new Philosopher("柏拉图",c2,c3),"柏拉图").start();
        new Thread(new Philosopher("苏格拉底",c3,c4),"苏格拉底").start();
        new Thread(new Philosopher("赫拉克利特",c4,c5),"赫拉克利特").start();
        new Thread(new Philosopher("阿基米德",c1,c5),"阿基米德").start();
    }
}
