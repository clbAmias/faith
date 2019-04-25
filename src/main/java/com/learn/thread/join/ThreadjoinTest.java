package com.qd.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenlongbo on 2017/5/26.
 */
public class ThreadjoinTest {

    public static class RunableJob implements Runnable{
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " start: " + new Date());
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println(thread.getName() + " end: " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        RunableJob job = new RunableJob();
        Thread t1 = new Thread(job,"T1");
        Thread t2 = new Thread(job,"T2");
        Thread t3 = new Thread(job,"T3");
        Thread t4 = new Thread(job,"T4");
        Thread t5 = new Thread(job,"T5");
        t4.start();
        t4.join();
        t5.start();
        t5.join();
        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
    }


}
