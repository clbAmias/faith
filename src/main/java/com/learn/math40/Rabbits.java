package com.qd.math40;

/**
 * Created by chenlongbo on 2017/6/3.
 */
public class Rabbits {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++ ){
            System.out.println("第"+i+"月,兔子的对数为:"+f(i));
        }
    }

    public static int f(int n){
        if(n == 1 || n == 2)
            return 1;
        else
        return f(n-1) + f(n - 2);
    }
}
