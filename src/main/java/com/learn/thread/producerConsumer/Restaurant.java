package com.qd.thread.producerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenlongbo on 2017/4/25.
 */
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(waitPerson);
        exec.execute(chef);
    }

    public static void main(String[] args) {
        new Restaurant();
    }

    class Meal {
        private final int orderNum;

        public Meal(int orderNum) {
            this.orderNum = orderNum;
        }

        public String toString() {
            return "Meal " + orderNum;
        }
    }

    class WaitPerson implements Runnable {
        private Restaurant restaurant;

        public WaitPerson(Restaurant r) {
            restaurant = r;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal == null) {
                            wait();
                        }
                        System.out.println("waitPerson got :" + restaurant.meal);
                    }
                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        restaurant.chef.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("waitPerson interrupted");
                e.printStackTrace();
            }
        }
    }

    class Chef implements Runnable {
        private Restaurant restaurant;
        private int count = 0;

        public Chef(Restaurant r) {
            restaurant = r;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal != null) {
                            wait();
                        }
                    }
                    if (++count == 10) {
                        System.out.println("out of food,closing");
                        restaurant.exec.shutdownNow();
                    }
                    System.out.println("order up ");
                    synchronized (restaurant.waitPerson) {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Chef interrupted");
                e.printStackTrace();
            }
        }
    }
}
