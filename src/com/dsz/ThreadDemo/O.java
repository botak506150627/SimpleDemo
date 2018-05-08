package com.dsz.ThreadDemo;

import java.util.concurrent.TimeUnit;

public class O {
    Object o = new Object();
    void m(){
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        O o1 = new O();
        new Thread(()->o1.m(),"T1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(()->o1.m(),"T2");
        o1.o = new Object();
        t2.start();
    }
}
