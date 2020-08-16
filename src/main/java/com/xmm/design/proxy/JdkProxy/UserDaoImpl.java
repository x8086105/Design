package com.xmm.design.proxy.JdkProxy;

/**
 * 用户Dao类
 */
public class UserDaoImpl implements UserDao {
    /**
     * 用来执行业务登录操作
     */
    @Override
    public void login(){

        System.out.println("开始执行业务登录操作");

    }
}
