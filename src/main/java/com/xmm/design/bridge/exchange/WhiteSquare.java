package com.xmm.design.bridge.exchange;

public class WhiteSquare extends Square{
    @Override
    public void draw() {
        System.out.println("白色的");
        super.draw();
    }
}
