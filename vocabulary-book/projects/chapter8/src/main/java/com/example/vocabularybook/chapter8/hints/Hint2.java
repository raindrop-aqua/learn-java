package com.example.vocabularybook.chapter8.hints;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hint2 {

    private Hint1 hint;

    public Hint1 getHint() {
        return hint;
    }

    public void setHint(Hint1 hint) {
        this.hint = hint;
    }

    private void printPath() {
        System.out.println(hint.getPath());
    }

    public static void main(String[] args) {
        // Spring Framework 設定ファイルを読み込み<1>
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        // Spring Framework が管理しているクラスよりインスタンスを取得する<2>
        Hint2 hint2 = context.getBean(Hint2.class);
        // 関数を呼び出し<3>
        hint2.printPath();
    }
}
