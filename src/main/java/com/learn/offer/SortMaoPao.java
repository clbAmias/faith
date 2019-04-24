package com.learn.offer;

public class SortMaoPao {
    /**
     * 冒泡排序:遍历一次找出最大值时间复杂度为 O(n^2)
     *
     * 选择排序:首先，找到数组中最小的那个元素，其次，将它和数组的第 一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。再次，在剩下的元素中 找到最小的元素，将它与数组的第二个元素交换位置。
     * 如此往复，直到将整个数组排序。这种方法 叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
     * N^2
     * */


    public static void main(String[] args) {

        int [] arr = new int []{2,5,9,4,6,11,0,33,99,44,88};
        for (int i = 0; i < arr.length-1;i++){
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]){
                    int tem = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tem;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }
}
