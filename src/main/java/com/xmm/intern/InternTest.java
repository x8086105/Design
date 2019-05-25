package com.xmm.intern;

/**
 * @Author: xuemingming
 * @Date: 2019/3/25 9:52
 **/
public class InternTest {
    public static void main(String[] args) {
        String s1 = "exists";
        String s2 = s1.intern();
        System.out.println(s1 == s2);

        String s3 = new String("isExists");
        String s4 = s3.intern();
        System.out.println(s3 == s4);
        //预期返回结果 true false
        String s5 = new String("111");
        String s6 = "111";
        s5.intern();
        System.out.println(s5 == s6);

        String s7 = new String("121") + new String("121");
        s7.intern();
        String s8 = "121121";
        System.out.println(s7 == s8);
        //预期返回结果 false true
        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
        //预期返回结果 true true
    }
}
