package com.xmm.design.template;

public class Client {
    public static void main(String[] args) {
        TemplateAbstract template = new ConcreteTemplate();
        template.templateMethod();
    }
}
