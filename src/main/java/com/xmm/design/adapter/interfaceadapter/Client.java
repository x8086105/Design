package com.xmm.design.adapter.interfaceadapter;

public class Client {

    public static void main(String[] args) {
        AbsAdapter1 adapter1 = new AbsAdapter1() {
            @Override
            public void m1() {
                System.out.println("使用到M1方法了");
                super.m1();
            }

            @Override
            public void m2() {
                //super.m2();
            }
        };
        adapter1.m1();
    }
}
