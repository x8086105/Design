package com.xmm.zhss.design.factory;

public class NonFactoryPatternDemo {

    public static void main(String[] args) {
        Product product = new Product("测试产品");
        System.out.println(product);

        //有什么问题？ 如果你直接面向一个类来编程，来创建类的实例的话，就是基本上会死的很惨
        //假设，如果对Product更换一个类的实现，此时就必须在创建类实例的地方，都要修改这个代码
        //如果此处业务逻辑用Product2来实现的话， 那整个实现都得修改，如果有100个地方创建了Product
        //实例，你需要在100个地方都去修改这段代码，这段代码的可维护性扩展性查，这就是垃圾代码
    }

    public static class Product{
        private String name;

        public Product(String name){
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
