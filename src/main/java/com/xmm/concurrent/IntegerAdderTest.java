package com.xmm.concurrent;

import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: xuemingming
 * @Date: 2019/5/24 17:54
 **/
public class IntegerAdderTest {
    public static void main(String[] args) {
        LongAdder la = new LongAdder();
        la.increment();
    }
}
