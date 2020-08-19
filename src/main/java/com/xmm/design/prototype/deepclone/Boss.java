package com.xmm.design.prototype.deepclone;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Boss extends AbstractObject{
    private String name;
    private Integer level;
}
