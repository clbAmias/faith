package com.qd.math40;

/**
 * Created by chenlongbo on 2017/6/18.
 */
public class ChildArray {
    public static void main(String[] args) {
        int[] a = new int[]{14, -3, -41, 3, 8, 91, -26, 66};
        sumN(a);
    }

    /**
     * 在时间复杂度为O(N)内找出数组中最大的子序列的累加和
     */
    public static int sumN(int[] array) {
        int n = array.length;
        int all = array[0], start = array[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if ((start + array[i]) > array[i]) {
                start = start + array[i];
            } else {
                start = array[i];
            }
            if (all < start) {
                all = start;
            }
            count++;
        }
        System.out.println("数组长度=" + array.length + "||时间复杂度=" + count);
        System.out.println("最大值:"+all);
        return all;
    }
}
