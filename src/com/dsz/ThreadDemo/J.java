package com.dsz.ThreadDemo;//volatile关键字可以防止指令重排序 读取主存中的值

import java.util.concurrent.TimeUnit;

public class J {
    /*volatile*/ boolean running = true;

    void m(){
        System.out.println(" m start");
        while (running){

        }
        System.out.println(" m end");
    }

    public static void main(String[] args) {
        J j = new J();
        new Thread(()->j.m()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j.running = false;
    }
}
