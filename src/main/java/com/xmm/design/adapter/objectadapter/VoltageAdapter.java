package com.xmm.design.adapter.objectadapter;

public class VoltageAdapter implements IVoltage5V{

    IVoltage220V iVoltage220V = null;


    public VoltageAdapter(IVoltage220V iVoltage220V){
        this.iVoltage220V = iVoltage220V;
    }
    @Override
    public int output5V() {
        int dst = 5;
        if(iVoltage220V != null){
            int src = iVoltage220V.output220V();
            System.out.println("开始进行适配");
            dst = src / 44;
            System.out.println("适配完成");
            return dst;
        }
        return dst;

    }
}
