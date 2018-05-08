package com.dsz.ThreadDemo;

public class D extends Thread{
    private  int count =10;
    @Override
    public /*synchronized*/ void run() {
        count --;
        System.out.println(Thread.currentThread().getName()+"count = "+count);
    }

    public static void main(String[] args) {
        D d= new D();
        for(int i = 0;i<5;i++){
            new Thread(d,"Thread"+i).start();
        }
    }
}
