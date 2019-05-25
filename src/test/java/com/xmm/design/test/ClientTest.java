package com.xmm.design.test;

import com.xmm.poi.Person;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    /**
     * 用来模拟jdk1.6和jdk1.7以及以后的版本String intern()方法
     * 常量池的區別
     */
    @Test
    public void testIntern(){
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        String a5 = new String("qqqqqq") + new String("qqqq");//只在堆上创建对象
        a5.intern();//在常量池上创建引用
        String a6 = "qqqqqqqqqq";//此时不会再在常量池上创建常量AA，而是将a5的引用返回给a6
        System.out.println(a5 == a6); //true
        System.out.println(a5.intern()==a6);
        System.out.println("----------");
        String a="qwe";
        String b=new String("qwe");
        System.out.println(a==b.intern());
    }

    /**
     * 測試内存溢出
     * 如果使用软引用的话，就可以有效的避免内存溢出了
     * 但是会获取的值是空值因为对象已经被回收了
     * -Xmx10m
     * 可以對比出 ，软引用和强引用的区别。强引用宁可报 oom异常也不会回收
     * 而软引用当内存不够的时候回回收
     */
    @Test
    public void testOOM(){
//        List<byte[]>bytes=new ArrayList<>();
//        while (true){
//            byte [] b=new byte[1*1024*1024];
//            bytes.add(b);
//        }
        //如果使用软引用的话
        List<SoftReference<byte[]>>bytes=new ArrayList<>();
        while (true){
            SoftReference<byte[]>b=new SoftReference<byte[]>(new byte[1*1024*1024]);
            bytes.add(b);
        }
    }
    @Test
    public void testLoadClass(){
        Person p = new Person();
        System.out.println(p.getClass().getClassLoader().getParent());
        System.out.println(p.getClass().getClassLoader().getParent().getParent());

    }
}
