package com.xmm.design.proxy.JdkProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        CommonInvocationHandler handler = new CommonInvocationHandler(userDao);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),handler);
        ProxyGeneratorUtils.writeProxyClassToHardDisk("F:/$Proxy11.class",proxy.getClass().getInterfaces());
        proxy.login();

    }

}
