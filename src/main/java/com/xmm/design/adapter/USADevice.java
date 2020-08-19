package com.xmm.design.adapter;

/**
 * 美国电器类
 */
public class USADevice implements Device{
    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (voltage == 110) {
            System.out.println("美国电器正常运行");
        } else {
            System.out.println("美国电器烧毁");
        }
        System.out.println();
    }
}
