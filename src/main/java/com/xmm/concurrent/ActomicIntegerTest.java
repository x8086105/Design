package com.xmm.concurrent;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xuemingming
 * @Date: 2019/5/24 17:26
 * 从该例子可以看出 仅仅用volatile修饰的变量还是会存在问题（这是因为原子性操作的缘故而volatile并不能保证原子性）
 *  而AtomicInteger 可以完美的解决该问题，但是还是会存在问题
 *  在高并发下大量线程会同时竞争同一个原子变量，但是只能有一个线程的CAS操作会成功，这就导致了大量的线程会竞争失败，
 *  会通过自旋尝试CAS操作，这就白白浪费了CPU资源 这时就可以看IntegerAdder 这个类可以解决这个问题
 *  但是不存在IntegerAdder只有LongAdder
 **/
public class ActomicIntegerTest {
    //9个 0
    private static Integer[] arr1 = {0,1,2,3,4,56,7,8,9,0,2,0,5,0,4,6,0,44,0,22,0,33,0,44,0};
    //11个0
    private static Integer[] arr2= {0,2,4,0,14,0,2,0,3,4,0,4,0,2,6,5,4,0,2,4,0,3,0,54,0,2,0,1,1,1,5};
    private static volatile Integer volatileSum=0;
    private static  Integer sum=0;
    private static AtomicInteger sumAtomic = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndSet(10);
        atomicInteger.set(100);
        atomicInteger.compareAndSet(100,200);
        atomicInteger.compareAndSet(100,500);
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
        atomicInteger.decrementAndGet();
        System.out.println(atomicInteger.get());
        atomicInteger.getAndDecrement();
        System.out.println("接下来使用两个线程，统计两个集合中元素为0的个数总和，分别用Integer和AtomicInteger来统计看有什么区别");
        //统计数组1的0元素的总数
        Thread thread1 = new Thread(() -> Arrays.stream(arr1).forEach(o->{
            if(o.equals(0)){
                sum++;
                volatileSum++;
                sumAtomic.incrementAndGet();
            }
        }));
        Thread thread2 = new Thread(() -> Arrays.stream(arr2).forEach(o->{
            if(o.equals(0)){
                sum++;
                volatileSum++;
                sumAtomic.incrementAndGet();
            }
        }));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("统计0的个数 用 Integer统计的是："+sum);
        System.out.println("统计0的个数 用 AtomicInteger统计的是："+sumAtomic.get());
        System.out.println("统计0的个数 用 用Volatile修饰的Integer统计的是："+volatileSum);
    }
}
