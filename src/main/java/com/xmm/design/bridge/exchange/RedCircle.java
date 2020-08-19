package com.xmm.design.bridge.exchange;

public class RedCircle extends Circle{
    @Override
    public void draw() {
        System.out.println("红色的");
        super.draw();
    }
}
