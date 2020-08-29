package com.xmm.design.proxy.CglibProxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        UserDao p = new UserDao();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\class");

        ProxyFactory factory = new ProxyFactory(p);
        UserDao userDaoProxy = (UserDao) factory.getProxyInstance();
        userDaoProxy.sayHello();
    }
}
