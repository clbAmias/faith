package com.learn.thread.producerConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenlongbo on 2017/4/24.
 */
public class Storage {

    //仓库最大存储量
    private  final  int MAX_SIZE = 100;

    //仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();

    //锁
    private  final Lock lock = new ReentrantLock();

    //仓库满的条件变量
    private final Condition full = lock.newCondition();

    //仓库空的变量条件
    private final Condition empty = lock.newCondition();

    //生产num个产品
    public  void produce(int num){
        //获得锁
        lock.lock();
        //如果仓库剩余量不足
        while(list.size() + num > MAX_SIZE){
            System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:" + list.size() + "/t暂时不能执行生产任务!");
            try {
            // 由于条件不满足，生产阻塞
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; ++i) {
            list.add(new Object());
        }
        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
        //唤醒其他所有线程
        full.signalAll();
        empty.signalAll();
        //释放锁
        lock.unlock();
    }

    //消费num个产品
    public void consume(int num){
        //获取所
        lock.lock();
        //如果仓库存储量不足
        while(list.size() < num){
            System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:" + list.size() + "/t暂时不能执行生产任务!");
            try {
                //消费阻塞
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费满足,消费num个产品
        for (int i = 0; i < num; i++) {
            list.remove();
        }
        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());
        //唤醒其他线程
        full.signalAll();
        empty.signalAll();
        //释放锁
        lock.unlock();
    }


    // set/get方法
    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }


    /**
     * 生产者类Producer继承线程类Thread
     *
     * Email:530025983@qq.com
     *
     * @author MONKEY.D.MENG 2011-03-15
     *
     */
    public static class Producer extends Thread
    {
        // 每次生产的产品数量
        private int num;

        // 所在放置的仓库
        private Storage storage;

        // 构造函数，设置仓库
        public Producer(Storage storage)
        {
            this.storage = storage;
        }

        // 线程run函数
        public void run()
        {
            produce(num);
        }

        // 调用仓库Storage的生产函数
        public void produce(int num)
        {
            storage.produce(num);
        }

        // get/set方法
        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }

        public Storage getStorage()
        {
            return storage;
        }

        public void setStorage(Storage storage)
        {
            this.storage = storage;
        }
    }
    /**
     * 消费者类Consumer继承线程类Thread
     */
    public static class Consumer extends Thread
    {
        // 每次消费的产品数量
        private int num;

        // 所在放置的仓库
        private Storage storage;

        // 构造函数，设置仓库
        public Consumer(Storage storage)
        {
            this.storage = storage;
        }

        // 线程run函数
        public void run()
        {
            consume(num);
        }

        // 调用仓库Storage的生产函数
        public void consume(int num)
        {
            storage.consume(num);
        }

        // get/set方法
        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }

        public Storage getStorage()
        {
            return storage;
        }

        public void setStorage(Storage storage)
        {
            this.storage = storage;
        }
    }



}
