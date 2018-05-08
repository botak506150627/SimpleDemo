package com.dsz.ThreadDemo;

public class F {
     public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end");
    }
    public void m2(){
        System.out.println(Thread.currentThread().getName()+"m2 strat...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }

    public static void main(String[] args) {
        F f = new F();
        /*new Thread(()->f.m1(),"f1").start();
        new Thread(()->f.m2(),"f2").start();*/
        new Thread(f::m1,"f1").start();
        new Thread(f::m2,"f2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f.m1();
            }
        },"f3").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f.m2();
            }
        },"f4").start();
    }
}
