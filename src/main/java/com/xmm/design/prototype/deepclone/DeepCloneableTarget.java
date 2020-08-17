package com.xmm.design.prototype.deepclone;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeepCloneableTarget implements Cloneable{
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    private Person person;

    private List<Integer> numbers;

    /**
     * 因为该类的属性， 都是String,因此我们这里使用默认的clone方法完成即可
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneableTarget target = null;
        target = (DeepCloneableTarget) super.clone();
        return target;
    }
}
