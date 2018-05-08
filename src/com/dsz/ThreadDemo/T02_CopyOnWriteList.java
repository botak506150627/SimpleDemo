package com.dsz.ThreadDemo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class T02_CopyOnWriteList {
    static void runAndComputeTime(Thread[] ths){
        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(o->o.start());
        Arrays.asList(ths).forEach(o->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }

    public static void main(String[] args) {
        List<String> list =
                new ArrayList<>();
                //new Vector<>();
                //new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];
        for(int i=0;i<ths.length;i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for(int i= 0;i<1000;i++){
                        list.add("a"+r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);
        }
        runAndComputeTime(ths);
        System.out.println(list.size());
    }
}
