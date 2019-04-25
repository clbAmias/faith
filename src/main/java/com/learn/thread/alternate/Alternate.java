package com.qd.thread.alternate;

/**
 * Created by chenlongbo on 2017/4/21.
 * 两个线程，一个打印1-100的奇数，一个打印1-100的偶数；
 * 要求:线程1打印5个之后，线程2开始打印，线程2打印5个之后，线程1再开始打印，以此循环。
 */
public class Alternate {
    private  static int state = 1;
    private  static int num1 = 1;
    private  static int num2 = 2;

    public static void main(String[] args) {
        final Alternate a = new Alternate();
        new Thread(
                new Runnable() {
                    public void run() {
                        while (num1 < 100){
                            synchronized(a){
                                if(a.state != 1){
                                    try {
                                        a.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                for (int i = 0; i < 5;i++){
                                    System.out.println(num1);
                                    num1 += 2;
                                }
                                state = 2;
                                a.notifyAll();
                            }

                        }
                    }
                }
        ).start();
        new Thread(
                new Runnable() {
                    public void run() {
                        while (num2 < 100){
                            synchronized(a){
                                if(a.state != 2){
                                    try {
                                        a.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                for (int i = 0; i < 5;i++){
                                    System.out.println(num2);
                                    num2 += 2;
                                }
                                state = 1;
                                a.notifyAll();
                            }

                        }
                    }
                }
        ).start();
    }

}
