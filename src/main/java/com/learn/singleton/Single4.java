package com.learn.singleton;

/**
 * Created by chenlongbo on 2017/4/24.
 */
// Version 4 双重检查版
public class Single4 {

    private static volatile Single4 instance;

    private Single4() {
    }

    public static Single4 getInstance() {
        if (instance == null) {
            synchronized (Single4.class) {
                //主要在于singleton = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
                //1. 给 singleton 分配内存
                // 2. 调用 Singleton 的构造函数来初始化成员变量，形成实例
                // 3. 将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
                // 但是在 JVM 的即时编译器中存在指令重排序的优化。
                // 也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3
                // 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），
                // 所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。所以要再次进行判断
                if (instance == null) {
                    instance = new Single4();
                }
            }
        }
        return instance;
    }
}
