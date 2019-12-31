package com.example.vocabularybook.chapter8.hints;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestHint1 {

    public void getSample() {
        try {
            Document document = Jsoup
                    .connect("http://localhost:8080/translate")
                    .data("word", "orange")
                    .get();
            Elements elements = document.select("#result");
            System.out.println(elements.get(0).text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void postSample() {
        try {
            Document document = Jsoup
                    .connect("http://localhost:8080/add")
                    .data("word1", "orange")
                    .data("word2", "みかん")
                    .post();
            Elements elements = document.select("#result");
            System.out.println(elements.get(0).text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
