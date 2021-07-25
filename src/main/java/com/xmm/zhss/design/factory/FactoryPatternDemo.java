package com.xmm.zhss.design.factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        Product product = ProductFactory.create();
        product.execute();
        //这就是面向接口编程，工厂方法模式的好处，如果此时有100个地方需要获取Product的实现
        //我们只需要修改工厂方法中的那个new即可。
        //spring会基于xml或者注解，根据一些配置，创建出来我们需要的这个类的实例
        //不care具体产品的实现类是谁实现的
        //我们在项目中，大量使用spring ioc这块功能 其实就是工厂模式
    }

    public interface Product{

        void execute();
    }

    public static class ProductImpl1 implements Product{

        @Override
        public void execute() {
            System.out.println("产品1的功能实现");
        }
    }

    public static class ProductFactory{
        public static Product create(){
            return new ProductImpl1();
        }
    }
}
