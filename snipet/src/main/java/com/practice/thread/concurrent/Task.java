package com.practice.thread.concurrent;

import java.util.*;
import java.util.concurrent.*;

public class Task implements Callable<String> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        long time = new Random(System.nanoTime()).nextInt(10000);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s is finished!", name));

        String taskReport = String.format("%s (id: %d, time: %d)", name, Thread.currentThread().getId(), time);
        return taskReport;
    }
}
