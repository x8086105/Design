package com.xmm.design.bridge.bridge;

public class Client {
    public static void main(String[] args) {
        Shape square = new Square();
        square.setIColor(new RedColor());
        square.draw();

        Shape circle = new Circle();
        circle.setIColor(new WhiteColor());
        circle.draw();
    }
}
