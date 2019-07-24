package com.xmm.stack;

import java.util.Arrays;
import java.util.HashMap;

public class MaoPaoSort {

    private static int []arr = {2,4,5,7,2,1,4,5,7,3,8,10};
    public static void main(String[] args) {
        System.out.println("排序前的数组是："+ Arrays.toString(arr));
        //arr = sort2(arr);
        //arr = sort3(arr);
        arr = qsort(arr,0,arr.length - 1);
        arr = countingSort(arr,arr.length-1);
        System.out.println("排序后的数组是："+Arrays.toString(arr));

    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    private static int[] sort(int[] arr) {
        if(arr.length == 1 || arr.length == 0){
            return arr;
        }
        for(int j = 0;j < arr.length; j++){
            for(int i = 0;i<arr.length - 1 - j;i++){
                if(arr[i] < arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    private static int[] sort2(int[] arr){

        for(int i = 1;i < arr.length; ++i) {
            int value = arr[i]; //用来保存当前待插入元素的变量值
            int j = i - 1;
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];  // 数据移动
                } else {
                    break;
                }
            }
            // 插入数据
            arr[j+1] = value;
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    private static int[] sort3(int[] arr){
        for(int i = 0;i<arr.length - 1; i++){
            int min = i;
            //首先在待排序中选择出最小的值
            for(int j = i + 1; j < arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            //然后在跟当前元素交换
            if(arr[i] != arr[min]){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    public static int[] sort4(int[] arr,int min,int max){
        if(min == max){
            return new int[] {arr[min]};
        }
        int mid = min + (max - min)/2;
        int[] leftArr = sort4(arr,min,mid);
        int[] rightArr = sort4(arr,mid + 1,max);
        int[] newArr = new int[leftArr.length + rightArr.length];
        int  m = 0, i = 0, j = 0;
        //合并
        while (i < leftArr.length && j < rightArr.length){
            newArr[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newArr[m++] = leftArr[i++];
        while (j < rightArr.length)
            newArr[m++] = rightArr[j++];
        return newArr;
    }
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[] { nums[l] };

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int[] qsort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) arr=qsort(arr,start,i-1);
        if (j+1<end) arr=qsort(arr,j+1,end);
        return (arr);
    }
    /**
     * 计数排序
     * @param a
     * @param n
     */
    public static int[] countingSort(int[] a, int n) {
        if (n <= 1) return a;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            //这一步计算出应该放在下标为几的位置
            int index = c[a[i]]-1;
            //计算出来直接将初始值赋值在这个下标的位置上
            r[index] = a[i];
            //然后将该总数 减1
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
        return a;
    }
}
