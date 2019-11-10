package com.example.vocabularybook.chapter6;

import com.example.vocabularybook.chapter6.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter6.dto.TranslateLogicOutDTO;
import com.example.vocabularybook.chapter6.logic.TranslateLogic;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Spring Framework 設定ファイルを読み込み<1>
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Spring Framework が管理しているクラスよりインスタンスを取得する<2>
        TranslateLogic logic = context.getBean(TranslateLogic.class);

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String command = sc.nextLine();
                // パラメータの作成
                TranslateLogicInDTO input = new TranslateLogicInDTO();
                input.setCommand(command);
                // ロジックを呼び出し
                TranslateLogicOutDTO output = logic.execute(input);
                // 終了判定
                if (output.isTerminate()) {
                    break;
                } else {
                    // ロジックからのメッセージを表示
                    System.out.println(output.getMessage());
                }
            }
        }
    }
}