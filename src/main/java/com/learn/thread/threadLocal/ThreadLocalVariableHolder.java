package com.learn.thread.threadLocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenlongbo on 2017/4/25.
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);

        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < 5; i++) {
                exec.execute(new Accessor(i));
            }
            TimeUnit.SECONDS.sleep(1);
            exec.shutdownNow();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
