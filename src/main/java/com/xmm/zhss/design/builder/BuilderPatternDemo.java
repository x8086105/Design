package com.xmm.zhss.design.builder;

import schemasMicrosoftComOfficeExcel.STObjectType;

public class BuilderPatternDemo {

    public static void main(String[] args) {
        Director director = new Director(new ConcreateBuilder());
        Product product = director.build("V1","V2","V3");
        System.out.println(product);

        //通过builder接口
    }

    public static class Product {

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

        @Override
        public String toString() {
            return "Product{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    ", field3='" + field3 + '\'' +
                    '}';
        }
    }

    public interface Builder {

        void field1(String value);

        void field2(String value);

        void field3(String value);

        Product create();

    }

    public static class ConcreateBuilder implements Builder {

        private Product product = new Product();

        @Override
        public void field1(String value) {

            System.out.println("在设置field1属性之前进行复杂的生成逻辑");
            product.setField1(value);
        }

        @Override
        public void field2(String value) {
            System.out.println("在设置field2属性之前进行复杂的生成逻辑");
            product.setField2(value);

        }

        @Override
        public void field3(String value) {
            System.out.println("在设置field3属性之前进行复杂的生成逻辑");
            product.setField3(value);

        }

        @Override
        public Product create() {
            return product;
        }
    }


    public static class Director {

        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product build(String field1, String field2, String field3) {
            builder.field1(field1);
            builder.field2(field2);
            builder.field3(field3);
            return builder.create();
        }
    }
}
