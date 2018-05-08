package com.dsz.ThreadDemo;

public class A {
    private int count = 10;
    public void m(){
        synchronized (this){
            count --;
            System.out.println(Thread.currentThread().getName()+"count ="+count);
        }
    }

}
