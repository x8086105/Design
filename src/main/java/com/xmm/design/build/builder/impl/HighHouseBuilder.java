package com.xmm.design.build.builder.impl;

import com.xmm.design.build.builder.HouseBuilder;

public class HighHouseBuilder extends HouseBuilder {
    @Override
    public HouseBuilder base(String base) {
        System.out.println("高楼大厦建造地基：" + base);
        house.setBase(base);
        return this;
    }

    @Override
    public HouseBuilder wall(String wall) {
        System.out.println("高楼大厦建造墙：" + wall);
        house.setWall(wall);
        return this;
    }

    @Override
    public HouseBuilder rootfed(String rootfed) {
        System.out.println("高楼大厦建造房顶：" + rootfed);
        house.setRootfed(rootfed);
        return this;
    }
}
