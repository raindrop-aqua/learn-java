package com.example.vocabularybook.chapter7;

import com.example.vocabularybook.chapter7.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter7.dto.TranslateLogicOutDTO;
import com.example.vocabularybook.chapter7.logic.TranslateLogic;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Spring Framework 設定ファイルを読み込み
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        // AOP設定を行ったBeanのインスタンスを取得する<1>
        TranslateLogic logic = (TranslateLogic) context.getBean("aopBookLogic");

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