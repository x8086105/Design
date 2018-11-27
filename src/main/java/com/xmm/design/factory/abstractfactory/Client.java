package com.xmm.design.factory.abstractfactory;

import com.xmm.design.factory.abstractfactory.excute.ComputerEngineer;
import com.xmm.design.factory.abstractfactory.factory.AmdFactory;
import com.xmm.design.factory.abstractfactory.factory.InterFactory;

/**
 * @author xuemingming
 */
public class Client {
    public static void main(String[] args) {
        ComputerEngineer computerEngineer=new ComputerEngineer();
        computerEngineer.makeComputer(new InterFactory());

        System.out.println("下面是另一个另一个品牌");

        computerEngineer.makeComputer(new AmdFactory());
    }
}
