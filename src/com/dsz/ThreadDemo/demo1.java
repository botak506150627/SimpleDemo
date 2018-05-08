package com.dsz.ThreadDemo;

public class demo1 {
    private int count = 10;
    private Object object =new Object();
    public void m(){
        synchronized (object){
            count --;
            System.out.println(Thread.currentThread().getName()+"count ="+count);
        }
    }

}
