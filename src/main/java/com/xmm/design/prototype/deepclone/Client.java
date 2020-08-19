package com.xmm.design.prototype.deepclone;

import com.google.common.collect.Lists;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = Person.builder().name("master").age(12).build();
        DeepCloneableTarget target = new DeepCloneableTarget("cloneName","cloneClass",
                person, Lists.newArrayList(1,2,3));
        DeepCloneableTarget target1 = (DeepCloneableTarget) target.clone();
        System.out.println(target);
        System.out.println(target1);
        System.out.println(target.getPerson() == target1.getPerson());
        System.out.println(target.equals(target1));
        System.out.println("target hashCode:" + target.hashCode());
        System.out.println("target1 hashCode:" + target1.hashCode());
        target.setCloneName("fuck");
        person.setAge(333);
        System.out.println(target);
        System.out.println(target1);
        test();
        test2();
    }

    /**
     * 相同类型的对象之间的拷贝
     * @throws CloneNotSupportedException
     */
    private static void test() throws CloneNotSupportedException {
        PersonVO vo = PersonVO.builder()
                .age(10)
                .name("xmm")
                .userId(10L)
                .boss(Boss.builder().name("xwf").level(10).build())
                .build();
        PersonVO vo2 = (PersonVO) vo.clone();
        System.out.println(vo2.getBoss().hashCode() == (vo.getBoss().hashCode()));
    }

    private static void test2(){
        PersonVO vo = PersonVO.builder()
                .age(10)
                .name("xmm")
                .userId(10L)
                .boss(Boss.builder().name("xwf").level(10).build())
                .build();
        try {
            PersonDTO vo2 = (PersonDTO) vo.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
