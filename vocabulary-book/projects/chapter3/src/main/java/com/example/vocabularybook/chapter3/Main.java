package com.example.vocabularybook.chapter3;

import com.example.vocabularybook.chapter3.dto.TranslateServiceInDTO;
import com.example.vocabularybook.chapter3.dto.TranslateServiceOutDTO;
import com.example.vocabularybook.chapter3.service.TranslateService;
import com.example.vocabularybook.chapter3.service.TranslateServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // サービスのインスタンスを生成
        TranslateService service = new TranslateServiceImpl();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String command = sc.nextLine();
                // サービスパラメータの作成
                TranslateServiceInDTO input = new TranslateServiceInDTO();
                input.setCommand(command);
                // サービスを呼び出し
                TranslateServiceOutDTO output = service.execute(input);
                // サービスの終了判定
                if (output.isTerminate()) {
                    break;
                } else {
                    // サービスからのメッセージを表示
                    System.out.println(output.getMessage());
                }
            }
        }
    }
}