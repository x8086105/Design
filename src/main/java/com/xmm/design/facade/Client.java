package com.xmm.design.facade;

public class Client {

    public static void main(String[] args) {
        BuyService buyService = new BuyServiceImpl();
        buyService.service();
    }
}
