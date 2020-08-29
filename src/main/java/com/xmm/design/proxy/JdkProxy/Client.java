package com.xmm.design.proxy.JdkProxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        ProxyFactory handler = new ProxyFactory(userDao);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserDao proxy = (UserDao) handler.getPorxyInstance();
        ProxyGeneratorUtils.writeProxyClassToHardDisk("F:/$Proxy11.class",proxy.getClass().getInterfaces());
        proxy.login();
    }

}
