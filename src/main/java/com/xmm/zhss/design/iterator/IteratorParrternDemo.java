package com.xmm.zhss.design.iterator;

import java.util.Iterator;

public class IteratorParrternDemo {


    /**
     * 定义一个自己的迭代器
     */
    public interface Iterator{

        public abstract boolean hasNext();

        public abstract Object next();
    }

    /**
     * 代表了一个迭代器
     */
    public interface Aggregate{

        public abstract Iterator iterator();

    }

    /**
     * 学生类
     */
    public class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public class Classroom implements Aggregate {

        private Student[] students;

        /**
         * 指针
         */
        private int last = 0;

        public Classroom(int size) {
            this.students = new Student[size];
        }

        public Student getStudent(int index) {
            return students[index];
        }

        public void addStudent(Student student) {
            this.students[last] = student;
            last++;
        }

        public int getLength() {
            return last;
        }

        @Override
        public Iterator iterator() {
            return new ClassroomIterator(this);
        }

    }

    /**
     * 教室迭代器
     */
    public class ClassroomIterator implements Iterator {

        private Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if(index < classroom.getLength()) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 从数组中获取当前这个学生，并且其游标往下移动一个
         * @return
         */
        @Override
        public Object next() {
            Student student = classroom.getStudent(index);
            index++;
            return student;
        }

    }




}
