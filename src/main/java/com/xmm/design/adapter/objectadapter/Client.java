package com.xmm.design.adapter.objectadapter;

import com.xmm.design.adapter.objectadapter.Phone;
import com.xmm.design.adapter.objectadapter.VoltageAdapter;

public class Client {
    public static void main(String[] args) {
        VoltageAdapter adapter = new VoltageAdapter(new IVoltage220V());
        Phone p = new Phone();
        p.charging(adapter);
    }
}
