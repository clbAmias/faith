package com.learn.singleton;

/**
 * Created by chenlongbo on 2017/4/24.
 */
//饿汉式实现
public class SingleB {
    private static final SingleB INSTANCE = new SingleB();

    private SingleB() {
    }

    public static SingleB getInstance() {
        return INSTANCE;
    }
}
