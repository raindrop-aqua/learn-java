package chapter4;

import chapter4.dto.TranslateLogicInDTO;
import chapter4.dto.TranslateLogicOutDTO;
import chapter4.logic.TranslateLogic;
import chapter4.logic.TranslateLogicImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ロジックのインスタンスを生成
        TranslateLogic logic = new TranslateLogicImpl();

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