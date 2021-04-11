package com.qd.sort;

import java.util.Arrays;

/**
 * Created by chenlongbo on 2017/4/26.
 * 快速排序
 */
public class QuickSort {

    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; //用子表的第一个记录做基准
        while (i < j) { //从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j]; //用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) //用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index; //将基准数值替换回a[i]
        sort(a, low, i - 1);
        sort(a, i + 1, hight);
    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }


    public static void main(String[] args) {

        int b[] = {49, 238, 22, 97, 123, 76, 32, 88, 49};
        quickSort(b);
        System.out.println(Arrays.toString(b));
    }

}
