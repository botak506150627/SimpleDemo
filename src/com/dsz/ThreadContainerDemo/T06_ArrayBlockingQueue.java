package com.dsz.ThreadContainerDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);//有界队列

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i<10;i++){
            strs.put("a"+i);
        }
        strs.put("aaa");
        strs.offer("aaa");
        strs.offer("aaa",1, TimeUnit.SECONDS);
        strs.add("aaa");
        System.out.println(strs);
    }

}
