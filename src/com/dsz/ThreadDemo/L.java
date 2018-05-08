package com.dsz.ThreadDemo;

import java.util.ArrayList;
import java.util.List;

public class L {
    int count = 0;
    synchronized void m(){
        for(int i = 0;i<1000;i++){
            count ++;
        }
    }

    public static void main(String[] args) {
        L l = new L();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0;i<10;i++){
            threads.add(new Thread(()->l.m(),"thread"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(l.count);
    }
}
