package com.xmm.design.proxy.CglibProxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) {
        UserProxy proxy = new UserProxy();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\class");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(proxy);
        UserDao p = (UserDao) enhancer.create();
        p.sayHello();
    }
}
