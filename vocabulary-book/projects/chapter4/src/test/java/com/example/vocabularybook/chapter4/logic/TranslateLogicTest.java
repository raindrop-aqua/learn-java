package com.example.vocabularybook.chapter4.logic;

import com.example.vocabularybook.chapter4.dto.TranslateLogicInDTO;
import com.example.vocabularybook.chapter4.dto.TranslateLogicOutDTO;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TranslateLogicTest {

    /**
     * 単語を登録して翻訳を行う
     */
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

    /**
     * 単語の上書きを行う<br>
     * 単語を削除した後、翻訳する
     */
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

        // appleの翻訳語を削除する
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

    /**
     * インスタンスを破棄した後、翻訳を行う
     */
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
        // ファイル上に登録された単語はインスタンスが破棄されても消えないことを確認する
        input = new TranslateLogicInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));
    }

    /**
     * 想定外のコマンドの実行を試みる
     */
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