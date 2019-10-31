package com.learn.singleton;

/**
 * Created by chenlongbo on 2017/4/24.
 * Effective Java 第一版推荐写法
 * 第一版推荐写法对于内部类SingletonHolder，它是一个饿汉式的单例实现，
 * 在SingletonHolder初始化的时候会由ClassLoader来保证同步使INSTANCE是一个真·单例。
 * 同时，由于SingletonHolder是一个内部类，只在外部类的Singleton的getInstance()中被使用，
 * 所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。
 * ——它利用了ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。
 */

public class EffectiveSingle1 {
    private static class SingletonHolder {
        private static final EffectiveSingle1 INSTANCE = new EffectiveSingle1();
    }

    private EffectiveSingle1() {
    }

    public static final EffectiveSingle1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
