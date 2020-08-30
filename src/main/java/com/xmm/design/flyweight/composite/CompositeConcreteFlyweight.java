package com.xmm.design.flyweight.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeConcreteFlyweight implements FlyWeight {

    private List<FlyWeight> flyweights = new ArrayList<FlyWeight>();

    public void add(FlyWeight flyweight){
        flyweights.add(flyweight);
    }

    public void remove(FlyWeight flyweight){
        flyweights.remove(flyweight);
    }


    @Override
    public void operation(String extrinsicState) {
        for (FlyWeight flyweight : flyweights){
            flyweight.operation(extrinsicState);
        }
    }
}