package com.xmm.zhss.design.builder;

/**
 * 不用构造器模式的时候 是怎样的
 */
public class NonBuilderPatternDemo {

    public static void main(String[] args) {
        //构造这个复杂的product对象
        Product product = new Product();
        //1.设置field1属性
        System.out.println("在设置field1属性之前进行复杂的生成逻辑");
        product.setField1("value1");
        //1.设置field2属性
        System.out.println("在设置field2属性之前进行复杂的生成逻辑");
        product.setField2("value2");
        //1.设置field3属性
        System.out.println("在设置field3属性之前进行复杂的生成逻辑");
        product.setField3("value3");

        //上面是简化的一个逻辑，实际上对于一些有几十个字段，甚至是上百个字段的复杂对象的构建，上面这段代码就会很膨胀
        //大量代码堆积在一起，维护性非常差，可读性非常差，一旦很粗类DNA变化么就需要在多个地方修改这段代码 恶心

    }


    public static class Product{

        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }
    }
}
