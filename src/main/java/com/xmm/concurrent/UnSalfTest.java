package com.xmm.concurrent;

import sun.misc.Unsafe;

/**
 * @Author: xuemingming
 * @Date: 2019/5/24 10:07
 * //模拟使用unsalf类
 **/
public class UnSalfTest {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private volatile long state = 0;
    static final long stateOffset = 0;
    static {

        try {
            unsafe.objectFieldOffset(UnSalfTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        UnSalfTest test = new UnSalfTest ();
        Boolean sucess = unsafe.compareAndSwapInt(test , stateOffset, 0 , 1) ;
        System . out . println(sucess) ;

    }
}
