package com.dsz.ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock5 extends Thread{
    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"get the lock");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r5 = new ReentrantLock5();
        Thread t1 = new Thread(r5);
        Thread t2 = new Thread(r5);
        t1.start();
        t2.start();
    }
}
