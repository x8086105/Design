package com.xmm.zhss.design.adaptee;

/**
 * 不用设计模式的实现
 */
public class NonAdapterPatternDemo {

    public static void main(String[] args) {
        OldInterface oldInterface = new OldInterfaceImpl();
        oldInterface.oldExecute();
        NewInterface newInterface = new NewInterfaceImpl();
        newInterface.newExecute();
        /**
         * 如果不适用设计模式的话，我们会存在什么问题呢？
         * 问题其实很明显，就是说，在我们新代码中，融合了新老两个接口，很麻烦的一个事情
         * 代码很恶心，面向的是规范和风格两个完全不同的接口，自己理解和维护的成本就提高了
         * 其次，假如说，现在不给使用老版本接口的机会，直接强制要求按照新版本走，老版本接口实现类就
         * 没法用了？难不成要基于新版本的接口重新写一套？ 用适配器模式
         */
    }

    /**
     * 老版本接口
     */
    public static interface OldInterface{
        void oldExecute();
    }

    /**
     * 老版本接口实现类
     */
    public static class OldInterfaceImpl implements OldInterface{

        @Override
        public void oldExecute() {
            System.out.println("老版本接口实现的功能逻辑");
        }
    }
    /**
     * 新版本接口
     */
    public static interface NewInterface{
        void newExecute();
    }

    /**
     * 薪版本接口实现类
     */
    public static class NewInterfaceImpl implements NewInterface{

        @Override
        public void newExecute() {
            System.out.println("薪版本接口实现的功能逻辑");
        }
    }
}
