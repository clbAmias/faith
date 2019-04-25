package com.learn.round;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by chenlongbo on 2017/4/27.
 */
public class RoundUpDown {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(Double.parseDouble("8.865")));
        System.out.println(df.format(Double.parseDouble("1.115")));
        System.out.println(df.format(Double.parseDouble("1.835")));
        System.out.println(df.format(Double.parseDouble("1.834")));
        System.out.println(df.format(Double.parseDouble("1.834")));
    }


}
