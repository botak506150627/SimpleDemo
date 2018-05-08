package com.dsz.ThreadDemo;//当线程抛出异常时会释放当前对象的锁

import java.util.concurrent.TimeUnit;

public class I {
    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName()+" count ="+count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5){
                int i = 1/0;
            }
        }
    }

    public static void main(String[] args) {
        I o = new I();
        new Thread(()->o.m(),"T1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->o.m(),"T2").start();
    }
}
