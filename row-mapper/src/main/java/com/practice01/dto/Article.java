package com.practice01.dto;

import java.text.MessageFormat;

/**
 * 記事のクラスです
 */
public class Article {

    /** 記事タイトル */
    private String title;
    /** 記事の本文 */
    private String content;

    /**
     * デフォルトコンストラクタ
     */
    public Article() {
        this.title = "";
        this.content = "";
    }

    /**
     * コンストラクタ
     * @param title 記事タイトル
     * @param content 記事の本文
     */
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 記事の内容を整形
     * @return 整形された記事
     */
    public String formatted() {
        // 改行コード
        String lineSeparator = System.getProperty("line.separator");
        // テンプレート
        String template = "title: {0}" + lineSeparator + "content: {1}";

        // MessageFormatクラスを利用して記事内容を整形する
        return MessageFormat.format(template, this.title, this.content);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
