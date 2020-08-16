package com.xmm.design.factory.abstractfactory.cpu;

public class AmdCpu implements Cpu {
    Integer pins = 0;
    public AmdCpu(Integer pins){
        this.pins=pins;
    }
    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}
