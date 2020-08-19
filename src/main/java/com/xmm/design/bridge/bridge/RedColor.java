package com.xmm.design.bridge.bridge;

import java.util.concurrent.ConcurrentSkipListMap;

public class RedColor implements IColor{
    @Override
    public void getColor() {
        System.out.println("红色的");
    }
}
