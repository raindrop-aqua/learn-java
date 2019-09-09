package com.example.vocabularybook.chapter2.hints;

public class Hint3 {
    public static void main(String[] args) {
        String command = "a apple りんご";
        String[] parsedCommand = command.split(" ");
        System.out.println(parsedCommand[0]);   // a
        System.out.println(parsedCommand[1]);   // apple
        System.out.println(parsedCommand[2]);   // りんご
    }
}
