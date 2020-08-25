package com.xmm.design.decorator.decoratorConcrete;

import com.xmm.design.decorator.component.Drink;
import com.xmm.design.decorator.decorator.Decorator;

public class ShortBlack extends Decorator {

    public ShortBlack(Drink drink) {
        super(drink);
        setDesc(" shortBlack ");
        setPrice(4.0f);
    }
}
