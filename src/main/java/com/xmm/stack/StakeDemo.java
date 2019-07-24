package com.xmm.stack;

/**
 * 使用数组实现一个顺序栈
 *
 */
public class StakeDemo {
    private static int size = 0;
    private static String[] arr = new String[0];
    private static int count;

    public static boolean push(String k){
        //这里代表数组已满
        if(count == arr.length){
            size = size == 0 ? 1 : 2*size;
            String[] oldArr = arr;
            arr = new String[size];
            for(int i=0;i<oldArr.length;i++){
                arr[i] = oldArr[i];
            }
        }
        arr[count] = k;
        ++count;
        return true;
    }

    public static String pop(){
        if(count == 0) return null;
        String s = arr[count - 1];
        --count;
        return s;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            StakeDemo.push(i+"");
            System.out.println("栈的大小为："+StakeDemo.arr.length);
            System.out.println("当前栈内元素个数为："+StakeDemo.count);
        }
        System.out.println("开始进行出栈操作");
        while (StakeDemo.count>0){
            System.out.println("出栈元素为："+StakeDemo.pop());
        }
        System.out.println("当前栈内元素个数为："+StakeDemo.count);
    }
}
