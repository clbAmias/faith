package com.qd.sort;

public class SelectionSort {

    /** 选择排序 时间复杂度 o(n2)**/

    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        for (int i = 0; i < arr.length-1; i++) {
            int k = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    k = j;
                }
                if(k != i){
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;

                }

            }

        }
        System.out.println("交换之hou：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
