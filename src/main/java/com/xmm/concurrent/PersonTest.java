package com.xmm.concurrent;

public class PersonTest {

    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<100000;i++){
                    Person.add();

                }
            }
        },"t1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<100000;i++){

                    Person.add();

                }
            }
        },"t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println(person.getAge());
    }
}
