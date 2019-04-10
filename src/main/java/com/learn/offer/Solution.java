package com.learn.offer;

public class Solution {

    /**
     * 二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
     * 因此从右上角开始查找，
     * 当要查找数字比右上角数字大时，下移；
     * 当要查找数字比右上角数字小时，左移；
     * 如果出了边界，则说明二维数组中不存在该整数
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        int m = array[0].length - 1;

        if (array.length==0 || m == 0){
            return false;
        }
        int n = 0;
        int temp = array[n][m];
        while (target != temp ){
            if(m>0 && n < array.length-1){
                if(target > temp){
                    n = n+1;
                }else if(target < temp){
                    m = m -1;
                }
                temp = array[n][m];
            }else{
                return false;
            }
        }


        return true;
    }

}