package com.xmm.stack;

public class Search {
    private static int [] arr = {1,2,3,4,5,6,7,7,7,7,8,9,10,11,12,13,14};
    public static void main(String[] args) {
        int searchValue = 7;
        int index = search2(arr,searchValue);
        int index2 = search2_first(arr,searchValue);
        int index3 = search2_last(arr,searchValue);
        int index4 = search2_first_1(arr,searchValue);
        int index5 = search2_last_1(arr,searchValue);
        System.out.println("查找值返回的下标是:" + index);
        System.out.println("查找值返回的下标(第一个匹配到的元素)是:" + index2);
        System.out.println("查找值返回的下标(最后一个匹配到的元素)是:" + index3);
        System.out.println("查找值返回的下标(第一个大于等于该元素的)是:" + index4);
        System.out.println("查找值返回的下标(最后一个小于等于该元素的)是:" + index5);
    }

    /**
     * 二分查找 返回下表
     * @param arr
     * @param value
     * @return
     */
    public static int search2(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mide = low + (high - low)/2;
            if(arr[mide] < value){
                low = mide + 1;
            }else if(arr[mide] > value){
                high = mide - 1;
            }else {
                return mide;
            }
        }
        return -1;
    }

    /**
     * 二分查找 返回下表
     * 查找第一个值等于给定值的元素（第一个）
     * @param arr
     * @param value
     * @return
     */
    public static int search2_first(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mide = low + (high - low)/2;
            if(arr[mide] < value){
                low = mide + 1;
            }else if(arr[mide] > value){
                high = mide - 1;
            }else {
                if(mide == 0 || arr[mide - 1] != value){
                    return mide;
                }else {
                    high = mide - 1;
                }

            }
        }
        return -1;
    }

    /**
     * 二分查找 返回下表
     * 查找最后一个值等于给定值的元素（最后一个）
     * @param arr
     * @param value
     * @return
     */
    public static int search2_last(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mide = low + (high - low)/2;
            if(arr[mide] < value){
                low = mide + 1;
            }else if(arr[mide] > value){
                high = mide - 1;
            }else {
                if(mide == arr.length - 1  || arr[mide + 1] != value){
                    return mide;
                }else {
                    low = mide + 1;
                }

            }
        }
        return -1;
    }
    /**
     * 二分查找 返回下表
     * 查找第一个值大于等于给定值的元素（第一个）
     * @param arr
     * @param value
     * @return
     */
    public static int search2_first_1(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mide = low + ((high - low) >> 1);
            if(arr[mide] < value){
                low = mide + 1;
            }else {
                if(mide == 0 || arr[mide-1] < value) {
                    return mide;
                }
                high = mide - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找 返回下表
     * 查找最后一个值小于等于给定值的元素（最后一个）
     * @param arr
     * @param value
     * @return
     */
    public static int search2_last_1(int[] arr,int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mide = low + ((high - low) >> 1);
            if(arr[mide] > value){
                high = mide - 1;
            }else {
                if(mide == arr.length -1 || arr[mide+1] > value) {
                    return mide;
                }
                low = mide + 1;
            }
        }
        return -1;
    }


}
