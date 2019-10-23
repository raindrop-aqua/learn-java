package com.example.vocabularybook.chapter4.hints;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Hint2 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "c:/temp/book.csv";

        BufferedReader br
            = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(new File(path)),
                    StandardCharsets.UTF_8));
    }
}
