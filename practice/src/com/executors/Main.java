package com.executors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ArrayList<MyRunnable> list = new ArrayList<>();
        ArrayList<MyCallable> list = new ArrayList<>();

//        for (int i = 0; i < (Math.random() * 100); i++) {
////            list.add(new MyRunnable());
//            list.add(new MyCallable());
//        }
//
//        ArrayList<Future<String>> futureList = new ArrayList<>();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < list.size(); i++) {
//            futureList.add(executorService.submit(list.get(i)));
//        }
//
////        Thread.sleep(2000);
//        for (int i = 0; i < futureList.size(); i++) {
//            System.out.println(i + " " + futureList.get(i).isDone());
//            System.out.println(i + " " + futureList.get(i).get());
//        }

//        FutureTask futureTask = new FutureTask((Runnable) () -> System.out.println("Future Task"), "1111");
//        futureTask.run();
//        System.out.println(futureTask.get());

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1234");
//            }
//        });

        MyRunnable runnable = new MyRunnable();
        runnable.run();

        System.out.println("---------------------");

        Thread thred = new Thread(runnable) {
            @Override
            public void run() {
                super.run();
                System.out.println("Thred!!!!!!");
            }
        };

        thred.start();

        System.out.println("------------------");

        new Thread(runnable).start();
    }
    
}

class MyRunnable implements Runnable {

    private static int count = 0;
    private int number = count;

    public MyRunnable() {
        count++;
    }

    @Override
    public void run() {
        System.out.println("My name #000" + number);
    }
}

class MyCallable implements Callable<String> {

    private static int count = 0;
    private int number = count;

    public MyCallable() {
        count++;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "My name #000" + number;
    }

}