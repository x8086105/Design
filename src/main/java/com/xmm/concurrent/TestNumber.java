package com.xmm.concurrent;

public class TestNumber {

    public  synchronized static void a() throws InterruptedException {
        Thread.sleep(10);
        System.out.println("1");
    }

    public  synchronized  void b() throws InterruptedException {
        System.out.println("2");

    }

    public static void main(String[] args) {
        TestNumber n1 = new TestNumber();
        TestNumber n2 = new TestNumber();
        new Thread(()->{
            try {
                TestNumber.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                n2.b();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
