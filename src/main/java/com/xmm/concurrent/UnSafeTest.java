package com.xmm.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: xuemingming
 * @Date: 2019/5/24 15:22
 * 上面那个测试类可以看出，直接那样使用会出现问题，是因为Unsafe类只能用于java的核心类
 * 他的类加载器是BootStrap 如果要用，应该用反射的方法获取
 **/
public class UnSafeTest {
    private volatile long state = 0;
    static long stateOffset = 0;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class unsafeClass = Unsafe.class;
        Field field= unsafeClass.getDeclaredField("theUnsafe");
        //设置成可取
        field.setAccessible (true );
        //获取到这个成员变量
        Unsafe unsafe = (Unsafe) field.get(null);
        stateOffset = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));
        Boolean success = unsafe.compareAndSwapInt(UnSafeTest.class,stateOffset,0,1);
        System.out.println(success+":"+stateOffset);

    }
}
