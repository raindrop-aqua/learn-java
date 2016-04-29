package com.practice.format;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBenchmarkDate {
    private static final String IN_STR = "20100530";
    private static final String PATTERN_STR = "([0-9]{4})([0-9]{2})([0-9]{2})";
    private static final Pattern PATTERN_DATE = Pattern.compile(PATTERN_STR);
    private static final int LOOP_COUNT = 1000000;

    public static void main(String[] args) {

        Runnable r1 = () -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < LOOP_COUNT; i++) {
                benchmarkCompiled(IN_STR);
            }
            System.out.println(String.format("compile    : %.2f", (double) (System.currentTimeMillis() - start) / 1000));

        };
        Runnable r2 = () -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < LOOP_COUNT; i++) {
                benchmarkNoCompile(IN_STR);
            }
            System.out.println(String.format("no compile : %.2f", (double) (System.currentTimeMillis() - start) / 1000));
        };
        Runnable r3 = () -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < LOOP_COUNT; i++) {
                benchmarkSubString(IN_STR);
            }
            System.out.println(String.format("substring  : %.2f", (double) (System.currentTimeMillis() - start) / 1000));
        };

        r1.run();
        r2.run();
        r3.run();
    }

    private static String benchmarkCompiled(final String str) {
        Matcher m = PATTERN_DATE.matcher(str);
        return m.replaceAll("$1/$2/$3");
    }

    private static String benchmarkNoCompile(final String str) {
        Pattern p = Pattern.compile(PATTERN_STR);
        Matcher m = p.matcher(str);
        return m.replaceAll("$1/$2/$3");
    }

    private static String benchmarkSubString(final String str) {
        if (StringUtils.isEmpty(str)) {
            return StringUtils.EMPTY;
        }
        return str.substring(0, 4) + "/" + str.substring(4, 6) + "/" + str.substring(6, 8);
    }
}
