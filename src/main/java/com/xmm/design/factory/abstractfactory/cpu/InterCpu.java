package com.xmm.design.factory.abstractfactory.cpu;

public class InterCpu implements Cpu {
    /**
     * CPU 的针脚数
     */
    private Integer pins = 0;
    public InterCpu(Integer pins){
        this.pins=pins;
    }
    @Override
    public void calculate() {
        System.out.println("Intel CPU的针脚数：" + pins);
    }

}
