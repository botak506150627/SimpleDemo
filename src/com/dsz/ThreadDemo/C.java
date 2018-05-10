package com.dsz.ThreadDemo;//当同步方法为静态方法不需要实例化后调用时  锁定的是class对象

public class C {
    private static int count = 10;
    public static synchronized void m(){
        count --;
        System.out.println(Thread.currentThread().getName()+"count ="+count);
    }
    public static  void mm(){
        synchronized (C.class){
            count --;
        }
    }
}
