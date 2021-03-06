package com.dsz.ThreadDemo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class TicketSell2 {
    static LinkedList<String> tickets = new LinkedList<>();
    static {
        for(int i =0;i<1000;i++) tickets.add("ticket"+i);
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            new Thread(()->{
                while (true){
                    synchronized (tickets){
                        if(tickets.size()<=0) break;
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了--"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
