package com.xmm.poi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xuemingming
 * @Date: 2019/2/1 11:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person  {
    private Integer age;
    private String name;
    private Integer sex;
    private String xxx;
}
