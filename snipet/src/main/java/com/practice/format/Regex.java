package com.practice.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        day();
        num();
    }

    /**
     * 正規表現を利用して日付を変換
     * 20150515 -> 2015/05/15）
     */
    private static void day() {
        String inStr = "20100530";
        String patternStr = "([0-9]{4})([0-9]{2})([0-9]{2})";

        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(inStr);

        String result = m.replaceAll("$1/$2/$3");
        System.out.println(result);
    }

    /**
     * 正規表現を利用して数字文字列をカンマ区切り（マイナス対応）
     * -12345678 -> -12,345,678
     */
    private static void num() {
        String inStr = "-12345678";
        String patternStr = "(?<=[0-9])(?=([0-9]{3})+$)";

        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(inStr);

        String result = m.replaceAll(",");
        System.out.println(result);
    }
}
