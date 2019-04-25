package com.qd.thread.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by chenlongbo on 2017/4/25.
 */
public class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException during put");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("working from take");
        }
        System.out.println("Exiting LiftOffRunner ");
    }
}
