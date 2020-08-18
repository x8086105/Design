package com.xmm.design.proxy.JdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHandler implements InvocationHandler {

    private Object object;

    public CommonInvocationHandler(Object o){
        this.object = o;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("使用JDK动态代理----start");
        Object invoke = method.invoke(object,objects);
        System.out.println("使用JDK动态代理----end");
        return invoke;
    }
}
