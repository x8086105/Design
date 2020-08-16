package com.xmm.design.proxy.CglibProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("-------- start ---------");
        Object intercept = methodProxy.invokeSuper(o, objects);
        System.out.println("-------- end ---------");
        return intercept;
    }
}
