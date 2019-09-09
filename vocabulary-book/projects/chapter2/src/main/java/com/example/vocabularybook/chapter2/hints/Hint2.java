package com.example.vocabularybook.chapter2.hints;

import java.util.HashMap;
import java.util.Map;

public class Hint2 {
    public static void main(String[] args) {
        Map<String, String> memory = new HashMap<String, String>();
        // コメントを外すとコンパイルエラー
        // （1は整数だが、String型のところに入れようとしている）
        //memory.put(1, "one");
        // これならOK
        memory.put("1", "one");
    }
}
