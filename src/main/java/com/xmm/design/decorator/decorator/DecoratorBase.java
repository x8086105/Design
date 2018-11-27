package com.xmm.design.decorator.decorator;

import com.xmm.design.decorator.component.MonkeyComponent;

/**
 * 装饰角色
 * 持有被装饰者的抽象对象。只能用来继承 不能直接用来实现
 * @author xuemingming
 */
public abstract class DecoratorBase implements MonkeyComponent {
    private MonkeyComponent monkeyComponent;
    public DecoratorBase(MonkeyComponent monkeyComponent){
        this.monkeyComponent=monkeyComponent;
    }

    /**
     * 这个方法必须要被重写
     */
    @Override
    public void skills() {
        monkeyComponent.skills();
    }
}
