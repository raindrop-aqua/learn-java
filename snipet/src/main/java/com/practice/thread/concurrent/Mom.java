package com.practice.thread.concurrent;

import java.util.*;
import java.util.concurrent.*;

public class Mom {

    private static String[] taskList = {"炊事", "洗濯", "掃除", "買物", "家計簿",};

    public static void main(String[] args) {


        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();

        for (String task : taskList) {
            list.add(service.submit(new Task(task)));
        }

        for (Future<String> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
