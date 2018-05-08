package com.dsz.ThreadDemo;//获取了当前对象的锁之后可以访问该对象的所有同步方法
/**
 * synchronized锁是可重入的
 */

import java.util.concurrent.TimeUnit;

public class G {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }
    synchronized  void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 start");
    }

    public static void main(String[] args) {
        G g = new G();
        new Thread(()->g.m1()).start();
    }
}
