package com.example.vocabularybook.chapter2.hints;

import java.util.HashMap;
import java.util.Map;

public class Hint1 {
    public static void main(String[] args) {
        Map<String, String> memory = new HashMap<String, String>();
        // 追加
        memory.put("apple", "りんご");
        // 検索
        boolean exists = memory.containsKey("apple");
        // 削除
        memory.remove("apple");
    }
}
