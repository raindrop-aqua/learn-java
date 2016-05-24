package com.practice.thread.basic;


import java.util.*;

public class Task implements Runnable {

    public static void main(String[] args) {
        String[] tasks = {"炊事", "洗濯", "掃除", "買物", "家計簿", };

        for (String task : tasks) {
            Thread t = new Thread(new Task(task));
            t.start();
        }
    }

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long time = new Random(System.nanoTime()).nextInt(10000);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String out = String.format("%s is finished! (id: %d, time: %d)", name, Thread.currentThread().getId(), time);
        System.out.println(out);
    }
}
