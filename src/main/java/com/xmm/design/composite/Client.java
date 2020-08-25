package com.xmm.design.composite;

public class Client {

    public static void main(String[] args) {
        Company root = new ConcreteCompany("总公司","管总事");
        root.add(new Department("总公司部门1","管分公司事情1"));
        root.add(new Department("总公司部门2","管分公司事情2"));

        ConcreteCompany comp = new ConcreteCompany("分公司1","管分公司事情1");
        comp.add(new Department("分公司部门11","管分公司部门1"));
        comp.add(new Department("分公司部门12","管分公司部门2"));
        root.add(comp);

        ConcreteCompany comp2 = new ConcreteCompany("分公司2","管分公司事情2");
        comp2.add(new Department("分公司部门21","管分公司部门1"));
        comp2.add(new Department("分公司部门22","管分公司部门2"));
        root.add(comp2);

        root.display(0);
        root.duty();
    }
}
