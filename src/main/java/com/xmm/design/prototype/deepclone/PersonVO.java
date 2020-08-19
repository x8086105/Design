package com.xmm.design.prototype.deepclone;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO extends AbstractObject{
    private Long userId;
    private String name;
    private Integer age;
    private Boss boss;
}
