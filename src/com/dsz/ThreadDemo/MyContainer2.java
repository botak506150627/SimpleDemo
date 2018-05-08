package com.dsz.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer2 {
    volatile List lists = new ArrayList();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer2 c = new MyContainer2();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                c.add(new Object());
                System.out.println("add"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
        new Thread(()->{
            while (true){
                if(c.size() == 5){
                    break;
                }
            }
            System.out.println("t2结束");
        },"T2").start();
    }
}
