package com.learn.thread.producerConsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by chenlongbo on 2017/4/25.
 */
public class LiftOffRunnerTest {
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg + "----");
        LiftOffRunner runer = new LiftOffRunner(queue);
        Thread t = new Thread(runer);
        t.start();
        for (int i = 0; i < 5; i++) {
            runer.add(new LiftOff(5));
        }
        getkey("press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println(" finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingDeque<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }

}
