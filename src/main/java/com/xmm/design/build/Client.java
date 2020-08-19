package com.xmm.design.build;

import com.xmm.design.build.builder.HouseDirector;
import com.xmm.design.build.builder.NewComputer;
import com.xmm.design.build.builder.impl.CommonHouseBuilder;
import com.xmm.design.build.builder.impl.HighHouseBuilder;
import com.xmm.design.build.product.House;
import com.xmm.design.prototype.deepclone.Person;

public class Client {
    public static void main(String[] args) {

        CommonHouseBuilder commonHouseBuilder = new CommonHouseBuilder();
        HouseDirector houseDirector = new HouseDirector(commonHouseBuilder);
        houseDirector.contructHouse("1","2","3");

        Person s = Person.builder().age(10).build();
        NewComputer c = NewComputer.builder().cpu("xx").build();
        System.out.println(c);

    }
}
