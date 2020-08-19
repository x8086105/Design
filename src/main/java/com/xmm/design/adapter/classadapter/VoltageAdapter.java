package com.xmm.design.adapter.classadapter;

public class VoltageAdapter extends IVoltage220V implements IVoltage5V{


    @Override
    public int output5V() {
        //这里拿到输入电压为220V 然后要做适配就要转成5V
        int src = output220V();
        return src / 44;
    }
}
