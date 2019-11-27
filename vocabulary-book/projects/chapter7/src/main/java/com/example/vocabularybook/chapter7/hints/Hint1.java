package com.example.vocabularybook.chapter7.hints;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hint1 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hint1 logic = (Hint1) context.getBean("aopHintBean1");
        logic.execute();
    }

    // この関数では execute という文字列のみ出力していますが、実際に実行するとBefore、Afterが表示されます。<1>
    public void execute() {
        System.out.println("execute");
    }
}
