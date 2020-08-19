package com.xmm.design.build.builder;

import com.xmm.design.build.product.House;

/**
 * 抽象的建造流程
 */
public abstract class HouseBuilder {
    //建造者模式的抽象建造者
    public House house = new House();

    public abstract HouseBuilder base(String base);

    public abstract HouseBuilder wall(String wall);

    public abstract HouseBuilder rootfed(String rootfed);

    public House builder(){
        return house;
    }

}
