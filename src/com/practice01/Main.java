package com.practice01;

import com.practice01.dto.Article;
import com.practice01.service.impl.ArticleDBService;
import com.practice01.service.ArticleService;
import com.practice01.service.impl.ArticleFileService;

public class Main {

    public static void main(String[] args) {

        // 記事サービスを利用
        ArticleService service;
        // 記事データ
        Article article;

        // ファイルより記事を取得(フェーズ１)
        service = new ArticleFileService();
        article = service.read(2015, 04);
        System.out.println(article.formatted());

        // DBより記事を取得(フェーズ２)
        service = new ArticleDBService();
        article = service.read(2015, 04);
        System.out.println(article.formatted());
    }
}
