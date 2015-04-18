package com.practice01.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleTest {

    @Test
    public void testFormatted() throws Exception {
        Article a = new Article("記事タイトルです", "記事内容です。");
        String sep = System.getProperty("line.separator");

        String articleString = "title: 記事タイトルです" + sep + "content: 記事内容です。";
        assertEquals(articleString, a.formatted());
    }
}