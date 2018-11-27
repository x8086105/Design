package com.xmm.design.decorator.decoratorConcrete;

import com.xmm.design.decorator.component.MonkeyComponent;
import com.xmm.design.decorator.decorator.DecoratorBase;

public class DecoratorConcreteC extends DecoratorBase {

    public DecoratorConcreteC(MonkeyComponent monkeyComponent) {
        super(monkeyComponent);
    }

    @Override
    public void skills() {
        super.skills();
        System.out.println("叮！变成Super me 可以跑");
    }
}
