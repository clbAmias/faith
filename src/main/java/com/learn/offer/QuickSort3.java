package algorithm;

import java.util.Arrays;

/**
 * @author yugenhai
 */
public class QuickSort3 {


    public static void main(String[] args) {
        int[] arrays = {3, 4, 6, 1, 8, 2, 5, 10, 7, 9};
        quickSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }


    /**
     * 快排
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        //声明一个数来存 基准数


        if (data == null || left < 0 || right > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }

        if (left >= right) {
            return;
        }
        //从小到大
        int index = partition(arr, left, right);
        //一直递归处理左边的一堆数
        quickSort(arr, left, index - 1);
        //一直递归处理右边的一堆数
        quickSort(arr, index + 1, right);


    }


    /**
     * 分片排序
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        //取一个参照数
        int temp = arr[left];
        //一直可以排序
        while (left < right) {
            //第一次右边先走  右边往左边一步一步移动
            while (left < right && arr[right] >= temp) {
                //右边向左一步
                right--;
            }
            //交换位置
            arr[left] = arr[right];
            //左边往右边走
            while (left < right && arr[left] <= temp) {
                left++;
            }
            //交换位置
            arr[right] = arr[left];
        }
        //碰面了把参照数交给往右走的
        arr[left] = temp;
        //返回左边的数
        return left;
    }
}