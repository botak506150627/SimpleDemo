package com.dsz.ThreadDemo;

public class E implements Runnable{
    private  int count =10;
    @Override
    public synchronized void run() {
        count --;
        System.out.println(Thread.currentThread().getName()+"count ="+count);
    }

    public static void main(String[] args) {
        E e = new E();
        for(int i=0;i<5;i++){
            new Thread(e,"Thread"+i).start();
        }
    }
}
