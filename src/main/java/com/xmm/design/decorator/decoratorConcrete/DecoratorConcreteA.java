package com.xmm.design.decorator.decoratorConcrete;

import com.xmm.design.decorator.component.MonkeyComponent;
import com.xmm.design.decorator.decorator.DecoratorBase;

/**
 * 具体装饰角色A
 * @author xuemingming
 */
public class DecoratorConcreteA  extends DecoratorBase {

    public DecoratorConcreteA(MonkeyComponent monkeyComponent) {
        super(monkeyComponent);
    }

    /***
     * super 方法一定要调用父类的方法，不然该方法就会覆盖
     */
    @Override
    public void skills() {
        super.skills();
        System.out.println("变成了鱼,叮!获得游泳的本领+1");
    }

}
