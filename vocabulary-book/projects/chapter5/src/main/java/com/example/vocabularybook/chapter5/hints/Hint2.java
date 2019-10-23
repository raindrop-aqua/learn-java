package com.example.vocabularybook.chapter5.hints;

public class Hint2 {
    public static void main(String[] args) {
        String queryWord = "apple";
        String sql = "select * from book "
                   + "where word1 = " + queryWord;
    }
}
