package com.xmm.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体公司类
 */
public class Department implements Company{

    private String name;

    private String desc;

    public Department(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    /**
     * 部门集合
     */
    private List<Company> companies = new ArrayList<>();

    @Override
    public void add(Company company) {
        companies.add(company);
    }

    @Override
    public void remove(Company company) {
        companies.remove(company);

    }

    @Override
    public void display(int depth) {
        StringBuffer stringBuffer = new StringBuffer("-");
        for (int i = 0; i < depth ; i++) {
            stringBuffer.append("-");
        }

        System.out.println(stringBuffer.append(name));

        for (Company company: companies) {
            company.display(depth+2);
        }
    }

    @Override
    public void duty() {
        System.out.println(name + ":" + desc);
    }
}
