package com.cuncurrency.ReentrantLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static final int MAX_T = 2;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable w1 = new Worker(lock, "Job1");
        Runnable w2 = new Worker(lock, "Job2");
        Runnable w3 = new Worker(lock, "Job3");
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.shutdown();
    }
}

class Worker implements Runnable {
    String name;
    ReentrantLock lock;

    public Worker(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }
    public void run() {
        boolean done = false;
        while (!done) {
            boolean ans = lock.tryLock();

            if (ans) {
                try {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("task name - " + name
                            + " outer lock acquired at "
                            + ft.format(d)
                            + " Doing outer work");
                    Thread.sleep(1500);

                    lock.lock();
                    try {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");
                        System.out.println("task name - " + name
                                + " inner lock acquired at "
                                + ft.format(d)
                                + " Doing inner work");
                        System.out.println("Lock Hold Count - " + lock.getHoldCount());
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("task name - " + name +
                                " releasing inner lock");

                        lock.unlock();
                    }
                    System.out.println("Lock Hold Count - " + lock.getHoldCount());
                    System.out.println("task name - " + name + " work done");

                    done = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("task name - " + name +
                            " releasing outer lock");

                    lock.unlock();
                    System.out.println("Lock Hold Count - " +
                            lock.getHoldCount());
                }
            } else {
                System.out.println("task name - " + name +
                        " waiting for lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
