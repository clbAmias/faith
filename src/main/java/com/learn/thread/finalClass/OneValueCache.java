package com.learn.thread.finalClass;

/**
 * Created by chenlongbo on 2017/6/20.
 * 不可变类,线程安全
 */

import java.io.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

class OneValueCache {

    private  final BigInteger lastNumber;
    private  final BigInteger[] lastFactors;

    public OneValueCache (BigInteger i,BigInteger [] factors){
        lastNumber=i;
        lastFactors= Arrays.copyOf(factors,factors.length);
    }

   public BigInteger[] getFactors(BigInteger i){
        if(lastNumber==null || !lastNumber.equals(i)){
            return null;
        }
        else
            return Arrays.copyOf(lastFactors,lastFactors.length);
   }
}