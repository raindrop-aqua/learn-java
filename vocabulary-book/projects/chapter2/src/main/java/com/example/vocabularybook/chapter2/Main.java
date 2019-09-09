package com.example.vocabularybook.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<String, String> memory = new HashMap<>();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String command = sc.nextLine();

                if ("".equals(command)) {
                    break;
                }

                String[] parsedCommand = command.split(" ");
                try {
                    switch (parsedCommand[0].toUpperCase()) {
                        case "T":
                            String queryWord = parsedCommand[1];
                            String translatedWord = memory.get(queryWord);

                            if (translatedWord == null) {
                                System.out.println(String.format("%s -> %s",
                                        queryWord, "登録されていません"));
                            } else {
                                System.out.println(String.format("%s -> %s",
                                        queryWord, translatedWord));
                            }
                            break;
                        case "A":
                            String newWord = parsedCommand[1];
                            String newTranslatedWord = parsedCommand[2];
                            // 追加前に単語を削除
                            memory.remove(newWord);
                            // 単語を追加
                            memory.put(newWord, newTranslatedWord);
                            System.out.println("登録しました");
                            break;
                        case "D":
                            String deleteWord = parsedCommand[1];
                            memory.remove(deleteWord);
                            System.out.println("削除しました");
                            break;
                        default:
                            // コマンドにミスがあったとき
                            System.out.println("よくわかりませんでした");
                            break;
                    }
                } catch (Exception e) {
                    // コマンドにミスがあったとき
                    System.out.println("よくわかりませんでした");
                }
            }
        }
    }
}
