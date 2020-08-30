package com.xmm.design.decorator.client;

import com.xmm.design.decorator.component.Drink;
import com.xmm.design.decorator.concrete.Coffee;
import com.xmm.design.decorator.decorator.Decorator;
import com.xmm.design.decorator.decoratorConcrete.*;

public class CoffeeClient {
    public static void main(String[] args) {
        //声明一个被装饰者的coffee
        Drink drink = new DeCof();
        System.out.println("drink---desc:" + drink.getDesc() + "; drink---price:" + drink.getPrice());
        Decorator milk = new Milk(drink);
        System.out.println("milk---desc:" + milk.getDesc() + "; milk---price:" + milk.cost());

        Decorator shortBlack = new ShortBlack(milk);
        System.out.println("shortBlack---desc:" + shortBlack.getDesc() + "; shortBlack---price:" + shortBlack.cost());



    }
}
