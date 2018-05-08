package com.dsz.ThreadDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock3 {
    Lock lock = new ReentrantLock();
    void m1(){
        lock.lock();
        try {
            for(int i =1;i<=10;i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void m2(){
        /*boolean locked = lock.tryLock();
        System.out.println("m2..."+locked);
        if(locked) lock.unlock();*/
        boolean locked =false;
        try {
            locked = lock.tryLock(11,TimeUnit.SECONDS);
            System.out.println("m2..."+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(locked) lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantLock3 r3 = new ReentrantLock3();
        new Thread(()->r3.m1()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->r3.m2()).start();
    }
}
