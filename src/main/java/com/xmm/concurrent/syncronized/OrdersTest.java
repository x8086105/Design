package com.xmm.concurrent.syncronized;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = {"1","4"},expect = Expect.ACCEPTABLE,desc = "ok")
@Outcome(id = {"0"},expect = Expect.ACCEPTABLE_INTERESTING,desc = "danger")
@State
public class OrdersTest {

    int num = 0;
    boolean ready = false;

    /**
     * 线程1 执行这个方法
     * @param r
     */
    @Actor
    public void actor1(I_Result r){
        if(ready){
            r.r1 = num + num;
        }else{
            r.r1 = 1;
        }
    }

    /**
     * 线程2 执行这个方法
     * @param r
     */
    @Actor
    public void actor2(I_Result r){
        num = 2;

        ready = true;
    }

}
