package com.xmm.concurrent;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            TimeUnit.MILLISECONDS.sleep(2);
            System.out.println("ing");
        }

    }
}
