package com.xmm.design.bridge.exchange;

public class Client {
    public static void main(String[] args) {
        RedCircle redCircle = new RedCircle();
        redCircle.draw();
        WhiteSquare whiteSquare = new WhiteSquare();
        whiteSquare.draw();
    }
}
