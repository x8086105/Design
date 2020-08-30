package com.xmm.design.proxy.JdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

public class ProxyFactory  {

    private Object object;

    public ProxyFactory(Object o){
        this.object = o;
    }


    public Object getPorxyInstance(){
        /**
         * 1.ClassLoader ：指定当前目标对象的类加载器
         * 2.interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
         * 3.InvocationHandler:事情处理，执行目标对象方法时，会触发事情处理器的方法，会把当前的执行的目标对象的方法作为
         * 一个参数传入
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new InvocationHandler(){


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK动态代理的开始！");
                Object o  = method.invoke(object,args);
                System.out.println("JDK动态代理的结束！");
                return o;
            }
        });
    }
}
