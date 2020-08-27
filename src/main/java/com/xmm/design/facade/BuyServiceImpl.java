package com.xmm.design.facade;

public class BuyServiceImpl implements BuyService{
    //订单服务
    private OrderService orderService = new OrderService();

    //物流服务
    private LogisticsService logisticsService = new LogisticsService();

    //支付服务
    private PayService payService = new PayService();

    @Override
    public void service() {
        orderService.service();
        payService.service();
        logisticsService.service();
    }
}
