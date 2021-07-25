package com.xmm.zhss.design.facade;

public class FacadePatternDemo {

    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade();
        facade.execute();
    }
    /**
     * 子系统1的门面类，
     * 就是封装了多个模块，实现一个功能，对外进行暴露
     *
     */
    public static class SystemFacade{

        public void execute(){
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();

            moduleA.execute();
            moduleB.execute();
            moduleC.execute();
        }
    }

    public static class ModuleA{

        public void execute(){
            System.out.println("子系统1的模块A的功能");
        }
    }

    public static class ModuleB{

        public void execute(){
            System.out.println("子系统1的模块B的功能");
        }
    }

    public static class ModuleC{

        public void execute(){
            System.out.println("子系统1的模块C的功能");
        }
    }

}
