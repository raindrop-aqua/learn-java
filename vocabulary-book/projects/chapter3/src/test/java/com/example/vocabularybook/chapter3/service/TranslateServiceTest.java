package com.example.vocabularybook.chapter3.service;

import com.example.vocabularybook.chapter3.dto.TranslateServiceInDTO;
import com.example.vocabularybook.chapter3.dto.TranslateServiceOutDTO;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TranslateServiceTest {

    @Test
    public void executeTest01() {
        TranslateService service = new TranslateServiceImpl();

        TranslateServiceInDTO input = new TranslateServiceInDTO();
        input.setCommand("a apple りんご");
        TranslateServiceOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateServiceInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateServiceInDTO();
        input.setCommand("");
        output = service.execute(input);
        assertThat(output.isTerminate(), is(true));
    }
    @Test
    public void executeTest02() {
        TranslateService service = new TranslateServiceImpl();

        TranslateServiceInDTO input = new TranslateServiceInDTO();
        input.setCommand("a apple りんご");
        TranslateServiceOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateServiceInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));

        // appleの翻訳語を上書きする
        input = new TranslateServiceInDTO();
        input.setCommand("a apple 林檎");
        output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateServiceInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> 林檎"));
        assertThat(output.isTerminate(), is(false));

        // appleの翻訳語を上書きする
        input = new TranslateServiceInDTO();
        input.setCommand("d apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("削除しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateServiceInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> 登録されていません"));
        assertThat(output.isTerminate(), is(false));

    }

    @Test
    public void executeTest03() {
        TranslateService service = new TranslateServiceImpl();

        TranslateServiceInDTO input = new TranslateServiceInDTO();
        input.setCommand("a apple りんご");
        TranslateServiceOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("登録しました"));
        assertThat(output.isTerminate(), is(false));

        input = new TranslateServiceInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> りんご"));
        assertThat(output.isTerminate(), is(false));

        // 再度インスタンスを生成（前のインスタンスは破棄される）
        service = new TranslateServiceImpl();
        // メモリ上に登録された単語はインスタンスが破棄されると消えてしまうことを確認する
        input = new TranslateServiceInDTO();
        input.setCommand("t apple");
        output = service.execute(input);
        assertThat(output.getMessage(), is("apple -> 登録されていません"));
        assertThat(output.isTerminate(), is(false));
    }

    @Test
    public void executeTest04() {
        TranslateService service = new TranslateServiceImpl();

        TranslateServiceInDTO input = new TranslateServiceInDTO();
        // aコマンドは３つ必要だが、２つしか指定されていない
        input.setCommand("a apple");
        TranslateServiceOutDTO output = service.execute(input);
        assertThat(output.getMessage(), is("よくわかりませんでした"));
        assertThat(output.isTerminate(), is(false));
    }
}