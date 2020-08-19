package com.xmm.design.adapter;

public class ChinaAdapter implements Device {

    private USADevice mUsaDevice;
    /**
     * 适配美国电器
     */
    public ChinaAdapter(USADevice usaDevice) {
        this.mUsaDevice = usaDevice;
    }

    public ChinaAdapter(){

    }
    @Override
    public void use(int voltage) {
        System.out.println("输入电压" + voltage + "V");
        if (mUsaDevice != null) {// 适配美国电器
            if (voltage == 110) {
                System.out.println("美国电器正常运行");
            } else {
                System.out.println("适配器工作...进行变压");
                voltage = 110;
                System.out.println("美国电器在" + voltage + "V正常运行");
            }
        } else {// 默认中国电器
            if (voltage == 220) {
                System.out.println("中国电器正常运行");
            } else {
                System.out.println("中国电器烧毁");
            }
        }
        System.out.println();
    }
}
