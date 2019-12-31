package com.example.vocabularybook.chapter8.handler;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.eclipse.jetty.util.IO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class VocabularyBookTest {

    @Test
    public void translateTest() {
        try {
            {// 単語を登録
                // 翻訳前に単語を登録しておく
                Document document = Jsoup
                        .connect("http://localhost:8080/add")
                        .data("word1", "apple")
                        .data("word2", "りんご")
                        .post();
                // ID属性を利用して結果を取得する<1>
                Elements elements = document.select("#result");
                assertThat(elements.size(), is(1));
                assertThat(elements.get(0).text(), is("登録しました"));
            }
            {// 単語を翻訳
                Document document = Jsoup
                        .connect("http://localhost:8080/translate")
                        .data("word", "apple")
                        .get();
                Elements elements = document.select("#result");
                assertThat(elements.size(), is(1));
                assertThat(elements.get(0).text(), is("apple -> りんご"));
            }
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void addAndDeleteTest() {
        try {
            {// 単語を登録
                Document document = Jsoup
                        .connect("http://localhost:8080/add")
                        .data("word1", "orange")
                        .data("word2", "みかん")
                        .post();
                Elements elements = document.select("#result");
                assertThat(elements.size(), is(1));
                assertThat(elements.get(0).text(), is("登録しました"));
            }
            {// 単語を翻訳
                Document document = Jsoup
                        .connect("http://localhost:8080/translate")
                        .data("word", "orange")
                        .get();
                Elements elements = document.select("#result");
                assertThat(elements.size(), is(1));
                assertThat(elements.get(0).text(), is("orange -> みかん"));
            }
            {// 単語を削除
                Document document = Jsoup
                        .connect("http://localhost:8080/delete")
                        .data("word", "orange")
                        .post();
                Elements elements = document.select("#result");
                assertThat(elements.size(), is(1));
                assertThat(elements.get(0).text(), is("削除しました"));
            }
            {// 単語を翻訳
                Document document = Jsoup
                        .connect("http://localhost:8080/translate")
                        .data("word", "orange")
                        .get();
                Elements elements = document.select("#result");
                assertThat(elements.size(), is(1));
                // 削除後は未登録であることを確認する<2>
                assertThat(elements.get(0).text(), is("orange -> 登録されていません"));
            }
        } catch (IOException e) {
            fail();
        }
    }
}