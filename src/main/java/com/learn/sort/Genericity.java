package com.learn.sort;

import java.util.ArrayList;
import java.util.List;

public class Genericity {


    public static void main(String[] args) {
        /** 泛型的原生**/


        List<String> a = new ArrayList<>();

        List<Integer> b = new ArrayList<>();


        System.out.println(a instanceof List);
    }
}
