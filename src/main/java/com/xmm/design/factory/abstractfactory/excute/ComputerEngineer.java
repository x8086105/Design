package com.xmm.design.factory.abstractfactory.excute;

import com.xmm.design.factory.abstractfactory.cpu.Cpu;
import com.xmm.design.factory.abstractfactory.factory.AbstractFactory;
import com.xmm.design.factory.abstractfactory.mainboard.MainBoard;

/**
 * @author xuemingming
 * 执行者
 */
public class ComputerEngineer {
    private Cpu cpu;
    private MainBoard mainBoard;
    public void makeComputer(AbstractFactory factory){
        prepareHardwares(factory);
    }
    private void prepareHardwares(AbstractFactory factory){
        this.cpu = factory.createCpu();
        this.mainBoard=factory.createMainBoard();

        this.cpu.calculate();
        this.mainBoard.installCpu();
    }
}
