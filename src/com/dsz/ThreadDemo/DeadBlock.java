package com.dsz.ThreadDemo;

import java.util.concurrent.TimeUnit;

public class DeadBlock {
    synchronized  void a1(){
        System.out.println(Thread.currentThread().getName()+" run a1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void a2(){
        System.out.println(Thread.currentThread().getName()+" run a2");
    }

    public static void main(String[] args) {
        DeadBlock a = new DeadBlock();
        DeadBlock b = new DeadBlock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("T1 start");
                    a.a1();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b.a2();
                }
            }
        },"T1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("T2 start");
                    b.a1();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a.a2();
                }
            }
        },"T2").start();
    }
}
