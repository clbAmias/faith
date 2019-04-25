package com.learn.singleton;

/**
 * Created by chenlongbo on 2017/4/24.
 */
// Version 2  懒汉式
public class Single2 {
    private static Single2 instance;
    private Single2() {}
    public static synchronized Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}
