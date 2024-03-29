package com.xmm.zhss.design.method;

public class NonFactoryMethodPatterDemo {


    public static void main(String[] args) {
        Product product1 = Product1Factory.createProduct();
        Product product2 = Product2Factory.createProduct();
        Product product3 = Product3Factory.createProduct();

        product1.execute();
        product2.execute();
        product3.execute();
        //问题在哪？
        //就会多个工厂类中，有生产产品的相同的通用逻辑，没有抽取出来，直接复制黏贴放多个工厂里了，如果
        //那段通用逻辑修改了，就需要到所有工厂中都要去修改
    }

    public interface Product{

        void execute();
    }

    public static class Product1 implements Product{

        @Override
        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class Product2 implements Product{

        @Override
        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class Product3 implements Product{

        @Override
        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }


    public static class Product1Factory{
        public static Product createProduct(){
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }
    }

    public static class Product2Factory{
        public static Product createProduct(){
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }
    }

    public static class Product3Factory{
        public static Product createProduct(){
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品3的特殊逻辑");
            return new Product3();
        }
    }
}
