package com.xmm.design.factory.abstractfactory.factory;

import com.xmm.design.factory.abstractfactory.cpu.AmdCpu;
import com.xmm.design.factory.abstractfactory.cpu.Cpu;
import com.xmm.design.factory.abstractfactory.mainboard.AmdMainBorad;
import com.xmm.design.factory.abstractfactory.mainboard.MainBoard;

/**
 * @author xuemingming
 */
public class AmdFactory implements AbstractFactory {
    private static Integer pins=99;
    @Override
    public Cpu createCpu() {
        return new AmdCpu(pins);
    }

    @Override
    public MainBoard createMainBoard() {
        return new AmdMainBorad(pins);
    }
}
