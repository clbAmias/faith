package com.learn.offer;

public class FinalString {
    /**
     * https://www.cnblogs.com/xiaoxi/p/6036701.html
     **/

    public static void main(String[] args) {
        String a = "hello2";

        final String b = "hello";
        String d = "hello";

        String c = b + "2";
        String e = d + "2";
        System.out.println((a == c));
        System.out.println((a == e));


    }

}
