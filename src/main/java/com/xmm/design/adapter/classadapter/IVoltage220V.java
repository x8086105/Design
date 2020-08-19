package com.xmm.design.adapter.classadapter;

/**
 * 这个是新增的类，为了适配之前5V的电压
 * 被适配的类
 */
public class IVoltage220V {
    /**
     * 输出电压为220V的
     * @return
     */
    public int output220V(){
        int src = 220;
        System.out.println("电压为 :" + src + "V");
        return src;
    }
}
