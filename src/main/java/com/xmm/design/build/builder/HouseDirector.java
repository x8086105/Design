package com.xmm.design.build.builder;

import com.xmm.design.build.product.House;

public class HouseDirector {
    HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder builder){
        this.houseBuilder = builder;
    }


    public House contructHouse(String base,String wall,String rootfed){
        houseBuilder.base(base);
        houseBuilder.wall(wall);
        houseBuilder.rootfed(rootfed);
        return houseBuilder.builder();
    }
}
