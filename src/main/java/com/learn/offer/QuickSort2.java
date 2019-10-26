package com.learn.offer;

import java.util.Arrays;

/**
 * @author CHENLONGBO809
 * @date 2019/3/14
 * @since portal
 */
public class QuickSort2 {

    public void quickSort_1(int[] data, int start, int end) {

        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }

        if (start == end) {
            return;
        }

        int index = partition(data, start, end);

        if (index > start) {
            quickSort_1(data, start, index - 1);
        }

        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
    }

    private int partition(int[] data, int start, int end) {
        //int index = start + (int)(Math.random() * (end - start + 1));
        //swap(data, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                small++;
                if (small != i) {
                    swap(data, i, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }

    private void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


}
