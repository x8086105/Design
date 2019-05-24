package com.xmm.concurrent;

import java.util.Random;

/**
 * @Author: xuemingming
 * @Date: 2019/5/23 17:37
 **/
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0;i<10;i++){

            System.out.println(random.nextInt(10));
        }
    }
}
