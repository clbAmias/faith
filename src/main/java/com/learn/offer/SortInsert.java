package com.learn.offer;

public class SortInsert {
    /**
     * 插入排序:
     * <p>
     * 对于 0 到 N-1 之间的每一个 i，将 a[i] 与 a[0] 到 a[i-1] 中比它小的所有元素依次有序地交换。
     * 在索引 i 由左向右变化的过程中，它左侧的元素总是有序的，所以当 i 到达数组的右端时排序就完成了。
     */

    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 9, 4, 6, 11, 0, 33, 99, 44, 88};

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
