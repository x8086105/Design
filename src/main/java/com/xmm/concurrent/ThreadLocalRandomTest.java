package com.xmm.concurrent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: xuemingming
 * @Date: 2019/5/23 18:02
 **/
public class ThreadLocalRandomTest {
    public static void main(String[] args) {

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for(int i=0;i<10;i++){
            System.out.println(threadLocalRandom.nextInt(10));
        }

    }
}
