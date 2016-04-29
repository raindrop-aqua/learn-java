package com.practice.format;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBenchmarkNum {

    private static final String IN_STR = "-123456789012345";
    private static final String PATTERN_STR = "(?<=[0-9])(?=([0-9]{3})+$)";
    private static final Pattern PATTERN_NUMBER = Pattern.compile(PATTERN_STR);
    private static final int LOOP_COUNT = 1000000;

    public static void main(String[] args) {

        Runnable r1 = () -> {
            StopWatch watch = new StopWatch();
            watch.start();
            for (int i = 0; i < LOOP_COUNT; i++) {
                benchmarkCompiled(IN_STR);
            }
            watch.stop();
            System.out.println(String.format("compile     : %.2f", (double) (watch.getTime()) / 1000));
        };
        Runnable r2 = () -> {
            StopWatch watch = new StopWatch();
            watch.start();
            for (int i = 0; i < LOOP_COUNT; i++) {
                benchmarkNonCompile(IN_STR);
            }
            watch.stop();
            System.out.println(String.format("non compile : %.2f", (double) (watch.getTime()) / 1000));
        };
        Runnable r3 = () -> {
            StopWatch watch = new StopWatch();
            watch.start();
            for (int i = 0; i < LOOP_COUNT; i++) {
                benchmarkSubString(IN_STR);
            }
            watch.stop();
            System.out.println(String.format("substring   : %.2f", (double) (watch.getTime()) / 1000));
        };

        r1.run();
        r2.run();
        r3.run();
    }

    private static String benchmarkCompiled(final String str) {
        Matcher m = PATTERN_NUMBER.matcher(str);
        return m.replaceAll(",");
    }

    private static String benchmarkNonCompile(final String str) {
        Pattern p = Pattern.compile(PATTERN_STR);
        Matcher m = p.matcher(str);
        return m.replaceAll(",");
    }

    private static String benchmarkSubString(final String str) {
        StringBuilder b = new StringBuilder();

        if (StringUtils.isEmpty(str)) {
            return StringUtils.EMPTY;
        }

        if (str.startsWith("-")) {
            b.append("-");
            Deque<String> stack = new ArrayDeque<>();
            int index = 1;

            for (int i = str.length() - 1; 0 < i; i--) {
                String s = str.substring(i, i + 1);
                stack.push(s);
                if (index % 3 == 0) {
                    stack.push(",");
                }
                index++;
            }
            while (true) {
                String s = stack.poll();
                if (StringUtils.isEmpty(s)) {
                    break;
                }
                b.append(s);
            }
        } else {
            Deque<String> stack = new ArrayDeque<>();
            int index = 1;

            for (int i = str.length() - 1; 0 <= i; i--) {
                String s = str.substring(i, i + 1);
                stack.push(s);
                if (index % 3 == 0) {
                    stack.push(",");
                }
                index++;
            }
            while (true) {
                String s = stack.poll();
                if (StringUtils.isEmpty(s)) {
                    break;
                }
                b.append(s);
            }
        }
        return b.toString();
    }
}
