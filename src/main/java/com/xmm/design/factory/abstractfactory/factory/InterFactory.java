package com.xmm.design.factory.abstractfactory.factory;

import com.xmm.design.factory.abstractfactory.cpu.Cpu;
import com.xmm.design.factory.abstractfactory.cpu.InterCpu;
import com.xmm.design.factory.abstractfactory.mainboard.InterMainBoard;
import com.xmm.design.factory.abstractfactory.mainboard.MainBoard;

/**
 * @author xuemingming
 */
public class InterFactory implements AbstractFactory {
    private static Integer pins=88;
    @Override
    public Cpu createCpu() {
        return new InterCpu(pins);
    }

    @Override
    public MainBoard createMainBoard() {
        return new InterMainBoard(pins);
    }
}
