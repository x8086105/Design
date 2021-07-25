package com.xmm.zhss.design.method;

public class FactoryMethodPatternDemo {


    public static void main(String[] args) {
        Product1Factory factory1 = Product1Factory.get();
        factory1.createProduct().execute();

        Product2Factory factory2 = Product2Factory.get();
        factory2.createProduct().execute();

        Product3Factory factory3 = Product3Factory.get();
        factory3.createProduct().execute();
    }

    public interface Product{

        void execute();
    }

     public static class Product1 implements Product {

        @Override
        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class Product2 implements Product {

        @Override
        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class Product3 implements Product {

        @Override
        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }

    public static abstract class AbstractProductFactory{
        public Product createProduct(){
            commonCreate();
            return specificCreate();
        }

        private void commonCreate(){
            System.out.println("生产产品的通用逻辑");
        }

        protected abstract Product specificCreate();
    }

    public static class Product1Factory extends AbstractProductFactory{
        private static final Product1Factory product1Factory = new Product1Factory();

        private Product1Factory(){

        }
        @Override
        protected Product specificCreate() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }

        public static Product1Factory get(){
            return product1Factory;
        }
    }

    public static class Product2Factory extends AbstractProductFactory{
        private static final Product2Factory product2Factory = new Product2Factory();

        private Product2Factory(){

        }
        @Override
        protected Product specificCreate() {
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }

        public static Product2Factory get(){
            return product2Factory;
        }
    }

    public static class Product3Factory extends AbstractProductFactory{
        private static final Product3Factory product3Factory = new Product3Factory();

        private Product3Factory(){

        }
        @Override
        protected Product specificCreate() {
            System.out.println("生产产品3的特殊逻辑");
            return new Product1();
        }

        public static Product3Factory get(){
            return product3Factory;
        }
    }
}
