package com.xmm.design.factory.abstractfactory.mainboard;

public class AmdMainBorad implements MainBoard {
    /**
     * CPU插槽的孔数
     */
    private Integer cpuHoles = 0;

    public AmdMainBorad(Integer cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCpu() {
        System.out.println("Amd主板的CPU插槽孔数是：" + cpuHoles);
    }
}
