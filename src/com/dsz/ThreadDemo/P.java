package com.dsz.ThreadDemo;//不要锁定字符串常量  此例中s1 s2为同一个String对象

public class P {
    String s1 = "Hello";
    String s2 = "Hello";
    void m1(){
        synchronized (s1){

        }
    }
    void m2(){
        synchronized (s2){

        }
    }
}
