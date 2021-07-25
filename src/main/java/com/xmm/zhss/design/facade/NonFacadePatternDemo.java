package com.xmm.zhss.design.facade;

/**
 * 外观模式
 */
public class NonFacadePatternDemo {

    public static void main(String[] args) {
        //假设我们这里是子系统2 ，要基于子系统1的3个模块功能实现一个业务逻辑
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
        //这么搞 会有什么问题？
        //1 对于子系统1来说，维护成本太高，就是因为要care多个子系统2的模块，如果只是三个模块还凑活，如果是
        //20个模块呢，那么子系统1对于子系统2的各个模块都要了解很多，维护成本高

        //2  多个模块组成的一个功能，如果在子系统多个地方用到的话，那么这块代码在多个地方就会重复出现很多，一旦
        //业务逻辑有变化，就要修改多个地方，很麻烦

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
