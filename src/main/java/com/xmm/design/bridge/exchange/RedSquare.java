package com.xmm.design.bridge.exchange;

public class RedSquare extends Square{
    @Override
    public void draw() {
        System.out.println("红色的");
        super.draw();
    }
}
