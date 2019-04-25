package com.learn.thread.callable;

import java.util.concurrent.Callable;

/**
 * Created by chenlongbo on 2017/4/24.
 */
public class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    public String call() throws Exception {
        return " result of TaskWithResult : "+id;
    }
}
