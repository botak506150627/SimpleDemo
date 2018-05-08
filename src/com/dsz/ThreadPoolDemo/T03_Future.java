package com.dsz.ThreadPoolDemo;

import java.util.concurrent.*;

public class T03_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(500);
                return 1000;
            }
        });
        new Thread(task).start();
        System.out.println(task.get());
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(500);
                return 1;
            }
        });
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }
}
