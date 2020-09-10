package com.xmm.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> list2 = Lists.newArrayList(33,55,88);
        //将list2插入的下标
        List<Integer> indexs = Lists.newArrayList(3,5,8);
        List<Integer> list3 = new ArrayList<>();
        for(int i = 0,k = 0; i<list1.size() + list2.size(); i++,k++){
            if(indexs.contains(i)){
                //进行插入操作
                list3.add(i,list2.get(indexs.indexOf(i)));
                k -- ;
            }else{
                Integer s= list1.get(k);
                list3.add(i,s);
            }
        }
        for(int i = 0;i<list3.size();i++){
            System.out.println(list3.get(i));

        }

    }
}
