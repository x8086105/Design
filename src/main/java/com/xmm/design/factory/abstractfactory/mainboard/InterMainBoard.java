package com.xmm.design.factory.abstractfactory.mainboard;

public class InterMainBoard implements MainBoard{
    /**
     * CPU插槽的孔数
     */
    private Integer cpuHoles = 0;

    public InterMainBoard(Integer cpuHoles){
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}
