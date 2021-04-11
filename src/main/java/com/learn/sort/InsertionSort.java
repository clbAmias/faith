package com.qd.sort;

public class InsertionSort {


    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 1, 3, 5, 6};
        for (int i = 1; i < arr.length; i++) {
            //只能从当前索引往前循环，因为索引前的数组皆为有序的，索引只要确定当前索引的数据的为止即可
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }


        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }

    }
}
