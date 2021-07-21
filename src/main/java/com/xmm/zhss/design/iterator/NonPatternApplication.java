package com.xmm.zhss.design.iterator;

import java.util.Map;

/**
 * 不用设计模式的实现方式
 */
public class NonPatternApplication {

    public static void main(String[] args) {
        ClassRoom room = new ClassRoom();
//        for(Student s : room.students){
//            System.out.println(s.getName());
//        }
        Map<String,Student> stringStudentMap = room.getStudents();
        for(Student s : stringStudentMap.values()){
            System.out.println(s.getName());
        }
        /**
         * 如果不适用任何设计模式的话，直接去遍历一个类中的集合，一旦这个
         * 类中的对集合的使用改版了，比如从数组变成了一个map或者一个list，还有
         * 别的可能，你迭代的这块代码就要改动
         *
         * 如果说代码和业务中的逻辑很复杂，改版成本就会很高了！！！
         * 可扩展性，维护性很差，所以 这就是shit一样的代码
         */
    }
    /**
     * 学生类
     */
    private static class Student {

        private String name;

        public Student(String name){

            this.name = name;
        }


        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }


    }

    /**
     * 教室类
     */
    private static class ClassRoom{

        //Student [] students = new Student[3];
        private Map<String,Student> students;
//        public Student[] getStudents() {

        public Map<String, Student> getStudents() {
            return students;
        }

        public void setStudents(Map<String, Student> students) {
            this.students = students;
        }
        public ClassRoom(){
            students.put("张三" ,new Student("张三"));
            students.put("李四" ,new Student("李四"));
            students.put("王五" ,new Student("王五"));
        }
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }
//
//        public ClassRoom(){
//            students[0] = new Student("张三");
//            students[1] = new Student("王五");
//            students[2] = new Student("李四");
//        }

    }
}
