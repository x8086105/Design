package com.xmm.design.prototype.deepclone;

import lombok.*;

@Getter
@ToString
@Builder
@Setter
public class Person implements Cloneable{
    private String name;
    private Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
