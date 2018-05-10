package com.dsz.ThreadDemo;//synchronized关键字声明在方法上

public class B {
    private int count = 10;
    public synchronized void m(){
            count --;
            System.out.println(Thread.currentThread().getName()+"count ="+count);
    }
}
