package com.xmm.design.bridge.exchange;

public class WhiteCircle extends Circle{
    @Override
    public void draw() {
        System.out.print("白色的");
        super.draw();
    }
}
