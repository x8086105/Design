package com.xmm.poi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xuemingming
 * @Date: 2019/3/14 17:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person2 {
    private Integer age;
    private String name;
    private Integer sex;
    private String desc;
}
