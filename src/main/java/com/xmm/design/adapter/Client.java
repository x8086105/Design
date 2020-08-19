package com.xmm.design.adapter;

public class Client {

    public static void main(String[] args) {
        ChinaAdapter chinaAdapter = new ChinaAdapter();
        chinaAdapter.use(220);

        chinaAdapter = new ChinaAdapter(new USADevice());
        chinaAdapter.use(220);
        chinaAdapter.use(110);
    }
}
