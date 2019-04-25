package com.learn.math40;

/**
 * Created by chenlongbo on 2017/6/3.
 */
public class Roem {


    public static void main(String[] args) {
        int a, b, c;
        for (int i = 100; i <= 999; i++) {
            //百位数
            a = i/100;
            //十位数
            b = (i % 100)/10;
            //个位数
            c = i % 10;
            if( i == a*a*a + b*b*b + c*c*c){
                System.out.println(i);
            }
        }
    }


}
