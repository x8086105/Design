package com.xmm.design.decorator.client;

import com.xmm.design.decorator.component.MonkeyComponent;
import com.xmm.design.decorator.concrete.MonkeyConcrete;
import com.xmm.design.decorator.decoratorConcrete.DecoratorConcreteA;
import com.xmm.design.decorator.decoratorConcrete.DecoratorConcreteB;
import com.xmm.design.decorator.decoratorConcrete.DecoratorConcreteC;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xuemingming
 */
public class Client {
    public static void main(String[] args) {
        MonkeyComponent monkey = new MonkeyConcrete();
        MonkeyComponent fish = new DecoratorConcreteA(monkey);
        MonkeyComponent bird = new DecoratorConcreteB(fish);
        MonkeyComponent superMe = new DecoratorConcreteC(bird);
        superMe.skills();
        System.out.println("xxxxzx");
        System.out.println("xxxxzx22");
        System.out.println("-----上述组合都用到了，下面个别用到的-------");
        MonkeyComponent monkey2 = new MonkeyConcrete();
        MonkeyComponent fish2 = new DecoratorConcreteA(monkey2);
        MonkeyComponent superMe2 = new DecoratorConcreteC(fish2);
        superMe2.skills();
        System.out.println("可以看出 装饰者模式自由组合");

    }

}
