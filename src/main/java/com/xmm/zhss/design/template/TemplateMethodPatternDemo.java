package com.xmm.zhss.design.template;

/**
 * 使用模板方法模式
 */
public class TemplateMethodPatternDemo {

    public static void main(String[] args) {
        DiscountCalculator1 discountCalculator1 = new DiscountCalculator1();
        discountCalculator1.calculate();
        DiscountCalculator2 discountCalculator2 = new DiscountCalculator2();
        discountCalculator2.calculate();
        DiscountCalculator3 discountCalculator3 = new DiscountCalculator3();
        discountCalculator3.calculate();
    }

    public interface DiscountCalculator{

        void calculate();
    }
    /**
     * 这是一个抽象类
     * 修改一处，处处修改了
     */
    public static abstract class AbstractDiscountCalculator implements DiscountCalculator{
        @Override
        public void calculate() {
            commonCalculate();
            specificCalculate();
        }
        public void commonCalculate(){
            System.out.println("执行共同的计算逻辑,修改了一下1");
        }

        protected abstract void specificCalculate();
    }

    public static class DiscountCalculator1 extends AbstractDiscountCalculator{

        @Override
        protected void specificCalculate() {

            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class DiscountCalculator2 extends AbstractDiscountCalculator{


        @Override
        protected void specificCalculate() {

            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class DiscountCalculator3 extends AbstractDiscountCalculator{

        @Override
        protected void specificCalculate() {

            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }
}
