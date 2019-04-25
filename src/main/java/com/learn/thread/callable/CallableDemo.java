package com.learn.thread.callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by chenlongbo on 2017/4/24.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            futures.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> fs:futures){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
