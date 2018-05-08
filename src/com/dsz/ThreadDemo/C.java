package com.dsz.ThreadDemo;

public class C {
    private static int count = 10;
    public static synchronized void m(){
        count --;
        System.out.println(Thread.currentThread().getName()+"count ="+count);
    }
    public static  void mm(){
        synchronized (C.class){
            count --;
        }
    }
}
