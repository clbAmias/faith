package com.learn.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenlongbo on 2017/4/24.
 */
public class SampleDemo {

    private final static CountDownLatch count = new CountDownLatch(2);

    private static class WorkingThread extends Thread {
        private final String mThreadName;
        private final int mSleepTime;

        private WorkingThread(String threadName, int sleepTime) {
            this.mThreadName = threadName;
            this.mSleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println("[" + mThreadName + "]  started!");
            try {
                TimeUnit.MILLISECONDS.sleep(mSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.countDown();
            System.out.println("[" + mThreadName + "]  end!");
        }
    }

    public static class SampleThread extends Thread {
        @Override
        public void run() {
            System.out.println("[SampleThread]  started---");
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[SampleThread]  end---");
        }
    }

    public static void main(String[] args) {

        new SampleThread().start();

        new WorkingThread("WorkingThread1", 3000).start();
        new WorkingThread("WorkingThread2", 5000).start();

    }
}
