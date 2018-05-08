package com.dsz.ThreadDemo;

public class B {
    private int count = 10;
    public synchronized void m(){
            count --;
            System.out.println(Thread.currentThread().getName()+"count ="+count);
    }
}
