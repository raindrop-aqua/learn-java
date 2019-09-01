package com.example.vocabularybook.chapter1.hints;

import java.util.Scanner;

public class Hint2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String line = sc.nextLine();
                if ("".equalsIgnoreCase(line)) {
                    break;
                }
            }
        }
    }
}
