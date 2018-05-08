package com.dsz.ThreadDemo;//原子操作  不需要synchronized关键字

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class M {
    AtomicInteger count = new AtomicInteger(0);
    void m(){
        for(int i = 0;i<1000;i++){
            //if(count.get()<1000)多个方法时不保证原子性
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        M m = new M();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0;i<10;i++){
            threads.add(new Thread(()->m.m(),"thread"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(m.count);
    }
}
