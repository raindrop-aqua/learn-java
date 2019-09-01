package com.example.vocabularybook.chapter1.hints;

import java.util.Scanner;

public class Hint1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            System.out.println(line);
        }
    }
}
