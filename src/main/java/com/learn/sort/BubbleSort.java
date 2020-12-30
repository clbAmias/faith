package com.learn.sort;

public class BubbleSort {

    /** 冒泡排序 时间平均复杂度O(n2)**/


    public static void main(String[] args) {

        int[] arr = {7, 2, 8, 1, 9, 0, 3};

        for(int i = 0; i < arr.length-1; i++){

            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);

        }

    }



}
