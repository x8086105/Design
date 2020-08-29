package com.xmm.design.proxy.CglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    public Object object;

    public ProxyFactory(Object o){
        this.object = o;
    }
    public Object getProxyInstance(){
        //1.设置一个工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(object.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理模式开始~");
        Object returnValue = method.invoke(object,args);
        System.out.println("cglib代理模式结束~");
        return returnValue;
    }

//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//
//        System.out.println("-------- start ---------");
//        Object intercept = methodProxy.invokeSuper(o, objects);
//        System.out.println("-------- end ---------");
//        return intercept;
//    }


}
