package com.dsz.ThreadDemo;//volatile关键字只能保证可见性 不能保证原子性

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class K {
    volatile int count = 0;
    //AtomicInteger count = new AtomicInteger(0);
    void m(){
        for(int i = 0;i<1000;i++){
            count ++;
           // count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        K k = new K();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0;i<10;i++){
            threads.add(new Thread(()->k.m(),"thread"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(k.count);
    }
}
