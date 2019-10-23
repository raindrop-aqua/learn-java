package com.example.vocabularybook.chapter4.hints;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Hint1 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "c:/temp/book.csv";

        BufferedWriter bw
            = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(new File(path)),
                    StandardCharsets.UTF_8));
    }
}
