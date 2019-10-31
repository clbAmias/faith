package com.learn.thread.producerConsumer;

/**
 * Created by chenlongbo on 2017/4/24.
 */
public class StorageTest {
    public static void main(String[] args) {
        // 仓库对象
        Storage storage = new Storage();


        // 生产者对象
        Storage.Producer p1 = new Storage.Producer(storage);
        Storage.Producer p2 = new Storage.Producer(storage);
        Storage.Producer p3 = new Storage.Producer(storage);
        Storage.Producer p4 = new Storage.Producer(storage);
        Storage.Producer p5 = new Storage.Producer(storage);


        // 消费者对象
        Storage.Consumer c1 = new Storage.Consumer(storage);
        Storage.Consumer c2 = new Storage.Consumer(storage);
        Storage.Consumer c3 = new Storage.Consumer(storage);


        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);


        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }

}
