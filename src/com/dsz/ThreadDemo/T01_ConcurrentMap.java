package com.dsz.ThreadDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentMap {
    public static void main(String[] args) {
        //Map<String,String> map = new ConcurrentHashMap<>();//
        //Map<String,String> map = new ConcurrentSkipListMap<>();//高并发且排序
        Map<String,String> map = new Hashtable<>();
        //Map<String,String> map = new HashMap<>();//Collectoins.synchronizedXXX
        //Map<String,String> map = new TreeMap<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for(int i = 0;i<ths.length;i++){
            ths[i] = new Thread(()->{
                for(int j = 0;j<10000;j++) map.put("a"+r.nextInt(),"a"+r.nextInt(100000));
                latch.countDown();
            });
            Arrays.asList(ths).forEach(o->o.start());
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        }
    }
}
