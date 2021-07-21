package com.xmm.zhss.design.adaptee;

/**
 * 使用适配器模式实现刚才的那两个东西
 */
public class AdapterPatternDemo {


    public static void main(String[] args) {
        NewInterface oldInterface = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newInterface = new NewInterfaceImpl();
        oldInterface.newExecute();
        newInterface.newExecute();

        //适配器模式
        //就是说手上有新接口和一个老接口的实现类
        //但是系统中强制面向新接口来开发，老接口实现类不能直接使用，不能面向老接口来开发
        //开发一个老接口到新接口的适配器，
        //适配器实现了新街口，但是持有老接口的一个实现类的实例引用
        //适配器的新接口功能，全部基于老接口来实现的
        //对于调用方，只要使用适配器开发即可，就可以以面向新接口来开发了，底层使用老接口实现类
    }

    /**
     * 定义一个适配器
     */

    public static class NewInterfaceAdapter implements NewInterface{

        private OldInterface oldInterface;

        public NewInterfaceAdapter(OldInterface oldInterface){
            this.oldInterface = oldInterface;
        }
        @Override
        public void newExecute() {
            oldInterface.oldExecute();
        }
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
