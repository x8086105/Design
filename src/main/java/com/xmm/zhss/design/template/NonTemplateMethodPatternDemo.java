package com.xmm.zhss.design.template;

/**
 * 不适用模板方法模式的时候 ，是怎样的
 *
 */
public class NonTemplateMethodPatternDemo {

    public static void main(String[] args) {
        DiscountCalculator1 discountCalculator1 = new DiscountCalculator1();
        discountCalculator1.calculate();
        DiscountCalculator2 discountCalculator2 = new DiscountCalculator2();
        discountCalculator2.calculate();
        DiscountCalculator3 discountCalculator3 = new DiscountCalculator3();
        discountCalculator3.calculate();
        // 有一个问题
        //就是说，这三个优惠方式的计算逻辑，都是有一个相同的计算逻辑，如果要用或者修改的话，
        //就要改三个地方，那这样可以把这段相同逻辑的代码抽取出来成一个公共方法
        //如果忘了修改某个类的公共代码，后果不堪设想，而且项目复杂的话， 这个公共方法就不知道放在了
        //哪些地方，这就是垃圾代码，扩展性 维护性 很烂，烂的离谱
    }

    public static class DiscountCalculator1{

        public void calculate(){
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class DiscountCalculator2{

        public void calculate(){
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器2的特殊计算逻辑");
        }
    }

    public static class DiscountCalculator3{

        public void calculate(){
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器2的特殊计算逻辑");
        }
    }
}
