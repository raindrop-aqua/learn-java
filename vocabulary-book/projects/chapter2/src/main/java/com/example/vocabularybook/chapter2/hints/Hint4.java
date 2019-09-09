package com.example.vocabularybook.chapter2.hints;

import java.util.HashMap;
import java.util.Map;

public class Hint4 {
    public static void main(String[] args) {
        // インスタンス生成<1>
        Map<String, String> map1 = new HashMap<String, String>();

        if (map1.isEmpty()) {
            // ifブロックの中でインスタンス生成<2>
            Map<String, String> map2 = new HashMap<String, String>();
        }
        // メソッドを呼ぶ
        doSomething();
    }

    public static void doSomething() {
        // メソッドの中でインスタンス生成<3>
        Map<String, String> map3 = new HashMap<String, String>();
    }
}
