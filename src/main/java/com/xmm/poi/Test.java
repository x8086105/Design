package com.xmm.poi;

import java.lang.reflect.ParameterizedType;

/**
 * @Author: xuemingming
 * @Date: 2019/2/1 11:36
 **/
public class Test<T> {
    private Class<T> beanClass;
    @SuppressWarnings("unchecked")
    public Test() {
ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
}

    public static void main(String[] args) {
        Test t = new Test();
    }
}