package com.xmm.design.factory.abstractfactory.factory;

import com.xmm.design.factory.abstractfactory.cpu.Cpu;
import com.xmm.design.factory.abstractfactory.mainboard.MainBoard;

/**
 * @author xuemingming
 */
public interface AbstractFactory {
    /**
     * @return
     * 创建cpu
     */
    Cpu createCpu();

    /**
     * 创建主板
     * @return
     */
    MainBoard createMainBoard();

}
