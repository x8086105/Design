package com.xmm.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put("aa","nn");
        hashMap.put(3104,"kk");
        System.out.println(hashMap.get(3104));
        System.out.println(hashMap.get("aa"));
        String ss = (String) hashMap.get(3104);
        int h  =  185%16;
        System.out.println(h);

        HashMap<Integer, String> map = new HashMap(16);
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果：");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }
        List<Integer> ll = new ArrayList<>();
    }
}
