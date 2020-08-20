package com.xmm.design.decorator.concrete;

import com.xmm.design.decorator.component.MonkeyComponent;

/**
 * @author xuemingming
 * 用来接收++装饰者，也就是被装饰者（最原始的动物。）
 */
public class MonkeyConcrete implements MonkeyComponent {
    @Override
    public void skills() {
        System.out.println("我是齐天大圣，会七十二变");
    }
}
