package com.example.vocabularybook.chapter3.logic;

import com.example.vocabularybook.chapter3.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter3.dto.TranslateLogicOutDTO;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TranslateLogicTest {

    @Test
    public void executeTest01() {
        TranslateLogic service = new TranslateLogicImpl();

        TranslateLogicInDTO input = new TranslateLogicInDTO();
        input.setCommand("a apple りんご");
        TranslateLogicOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateLogicInDTO();
        input.setCommand("");
        output = service.execute(input);
        assertThat(output.isTerminate(), is(true));
    }
    @Test
    public void executeTest02() {
        TranslateLogic service = new TranslateLogicImpl();

        TranslateLogicInDTO input = new TranslateLogicInDTO();
        input.setCommand("a apple りんご");
        TranslateLogicOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));

        // appleの翻訳語を上書きする
        input = new TranslateLogicInDTO();
        input.setCommand("a apple 林檎");
        output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> 林檎"));
        assertThat(output.isTerminate(), is(false));

        // appleの翻訳語を上書きする
        input = new TranslateLogicInDTO();
        input.setCommand("d apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("削除しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> 登録されていません"));
        assertThat(output.isTerminate(), is(false));
    }

    @Test
    public void executeTest03() {
        TranslateLogic service = new TranslateLogicImpl();

        TranslateLogicInDTO input = new TranslateLogicInDTO();
        input.setCommand("a apple りんご");
        TranslateLogicOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));

        // 再度インスタンスを生成（前のインスタンスは破棄される）
        service = new TranslateLogicImpl();
        // メモリ上に登録された単語はインスタンスが破棄されると消えてしまうことを確認する
        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> 登録されていません"));
        assertThat(output.isTerminate(), is(false));
    }

    @Test
    public void executeTest04() {
        TranslateLogic service = new TranslateLogicImpl();

        TranslateLogicInDTO input = new TranslateLogicInDTO();
        // aコマンドは３つ必要だが、２つしか指定されていない
        input.setCommand("a apple");
        TranslateLogicOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("よくわかりませんでした"));
        assertThat(output.isTerminate(), is(false));
    }
}