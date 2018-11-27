package com.xmm.design.decorator.decoratorConcrete;

import com.xmm.design.decorator.component.MonkeyComponent;
import com.xmm.design.decorator.decorator.DecoratorBase;

/**
 * 具体装饰角色B
 * @author xuemingming
 */
public class DecoratorConcreteB extends DecoratorBase {
    public DecoratorConcreteB(MonkeyComponent monkeyComponent) {
        super(monkeyComponent);
    }
    /***
     * super 方法一定要调用父类的方法，不然该方法就会覆盖
     */
    @Override
    public void skills() {
        super.skills();
        System.out.println("变成了鸟，叮！获得飞的功能");
    }
}
