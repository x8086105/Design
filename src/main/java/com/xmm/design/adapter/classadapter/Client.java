package com.xmm.design.adapter.classadapter;

public class Client {

    public static void main(String[] args) {
        VoltageAdapter adapter = new VoltageAdapter();
        Phone p = new Phone();
        p.charging(adapter);
    }
}
