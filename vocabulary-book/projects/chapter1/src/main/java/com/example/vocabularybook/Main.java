package com.example.vocabularybook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 単語帳を定義する<1>
        String[][] words = {
                {"apple", "りんご"},
                {"orange", "みかん"},
                {"house", "家"},
                {"cat", "猫"},
        };

        try (Scanner sc = new Scanner(System.in)) {
            // 入力を何回も受け付けるために、無限ループを作成<2>
            while (true) {
                // 何も入力しないときは終了<3>
                String command = sc.nextLine();
                if ("".equals(command)) {
                    break;
                }

                String translated = "登録されていません";
                // 単語帳から単語を探す<4>
                for (String[] word : words) {
                    // 単語がみつかった！<5>
                    if (word[0].equals(command)) {
                        translated = word[1];
                        break;
                    }
                }
                // 入力した単語と翻訳した語句をセットで出力<6>
                System.out.println(String.format("%s -> %s", command, translated));
            }
        }
    }
}
