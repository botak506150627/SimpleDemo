package com.dsz.ThreadDemo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Container2<T> {
    final private LinkedList<T> lists1 = new LinkedList<>();
    final private int MAX =10;
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();
    public void put(T t ){
        try {
            lock.lock();
            while (lists1.size() == MAX){
                producer.await();
            }
            lists1.add(t);
            ++count;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public T get(){
        T t = null;
        try {
            lock.lock();
            while (lists1.size() == 0){
                consumer.await();
            }
            t = lists1.removeFirst();
            count --;
            consumer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }
    public static void main(String[] args) {
        Container2<String> c = new Container2<>();
        for(int i = 0;i<10;i++){
            new Thread(()->{
                for(int j =0;j<5;j++){
                    System.out.println(c.get());
                }
            },"c"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<2;i++){
            new Thread(()->{
                for(int j = 0;j<25;j++){
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
