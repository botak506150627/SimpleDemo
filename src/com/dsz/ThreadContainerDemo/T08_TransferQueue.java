package com.dsz.ThreadContainerDemo;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue strs = new LinkedTransferQueue();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        strs.transfer("aaa");//没有消费者会阻塞
    }
}
