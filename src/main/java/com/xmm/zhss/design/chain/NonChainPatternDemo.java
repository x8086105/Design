package com.xmm.zhss.design.chain;

/**
 * 不用责任链模式
 */
public class NonChainPatternDemo {

    public static void main(String[] args) {
        //业务流程1
        System.out.println("执行功能1");
        System.out.println("执行功能2");
        System.out.println("执行功能3");


        //业务流程2
        System.out.println("执行功能3");
        System.out.println("执行功能1");
        System.out.println("执行功能2");
        /**
         * 这样写的话 有个问题，就是很多相同的业务流程，只是顺序执行的不一样，容易造成复制黏贴的情况
         * 如果需要修改一个东西，就要大量的复制 新增
         */
    }

}
