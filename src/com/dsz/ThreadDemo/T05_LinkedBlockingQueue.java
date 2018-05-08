package com.dsz.ThreadDemo;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T05_LinkedBlockingQueue {
    static BlockingQueue<String> str = new LinkedBlockingQueue<>();//无界队列
    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<100;i++){
                try {
                    str.put("a"+i);
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();
        for(int i=0;i<5;i++){
            new Thread(()->{
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+" take "+str.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }
}
