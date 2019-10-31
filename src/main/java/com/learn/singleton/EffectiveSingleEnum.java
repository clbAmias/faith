package com.learn.singleton;

/**
 * Created by chenlongbo on 2017/4/24.
 */
// Effective Java 第二版推荐写法
public enum EffectiveSingleEnum {
    INSTANCE;

    public void fun1() {
        // do something
    }
}

// 使用
//EffectiveSingleEnum.INSTANCE.fun1();
