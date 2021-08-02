package com.xmm.zhss.design.chain;

/**
 * 责任链模式
 */
public class ChainPatternDemo {

    public static void main(String[] args) {
        Handler1 handler1 = new Handler1(new Handler2(new Handler3()));
        handler1.execute();
        System.out.println("==================");
        Handler3 handler3 = new Handler3(new Handler1(new Handler2()));
        handler3.execute();
    }

    public static abstract class Handler{
        //后继handler
        public Handler successor;

        public Handler(){

        }

        public Handler(Handler successor){
            this.successor = successor;
        }
        public abstract void execute();
    }

    public static class Handler1 extends Handler{

        public Handler1(){
            super();
        }

        public Handler1(Handler successor){
            super(successor);
        }
        @Override
        public void execute() {
            System.out.println("这是Handler1的执行流程");
            if(successor != null){
                successor.execute();
            }
        }
    }

    public static class Handler2 extends Handler{

        public Handler2(){
            super();
        }

        public Handler2(Handler successor){
            super(successor);
        }
        @Override
        public void execute() {
            System.out.println("这是Handler2的执行流程");
            if(successor != null){
                successor.execute();
            }
        }
    }

    public static class Handler3 extends Handler{

        public Handler3(){
            super();
        }

        public Handler3(Handler successor){
            super(successor);
        }
        @Override
        public void execute() {
            System.out.println("这是Handler3的执行流程");
            if(successor != null){
                successor.execute();
            }
        }
    }
}
