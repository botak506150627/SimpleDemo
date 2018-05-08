package com.dsz.ThreadPoolDemo;

import java.util.concurrent.*;

public class T10_ThreadPoolExecotor {
    public static void main(String[] args) {
        ExecutorService service =new ThreadPoolExecutor(5,5,60,TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10));
    }

}
