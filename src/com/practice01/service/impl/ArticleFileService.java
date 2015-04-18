package com.practice01.service.impl;

import com.practice01.dto.Article;
import com.practice01.service.ArticleService;
import com.practice01.utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ファイルによって提供された記事を扱うクラス
 */
public class ArticleFileService implements ArticleService {

    /**
     * 記事を取得する
     *
     * @param year  年
     * @param month 月
     * @return 記事
     */
    @Override
    public Article read(int year, int month) {
        return readFile(year, month);
    }

    /**
     * ファイル名を作成する
     * ファイル名に年月が入るという仕様なのだけど、そういった部分は変更されやすい。
     *
     *
     * @param year 年
     * @param month 月
     * @return ファイル名
     */
    private String makeFileName(int year, int month) {
        return String.format("article-%02d-%02d.txt", year, month);
    }

    private Article readFile(int year, int month) {

        Article article = new Article();

        try{
            String fileName = makeFileName(year, month);
            String path = FileUtils.getFullPath("practice01/" + fileName);
            File file = new File(path);

            if (!file.exists()) {
                return article;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String sep = System.getProperty("line.separator");
            String str;
            int index = 0;
            StringBuilder body = new StringBuilder();

            while((str = br.readLine()) != null){
                if (index == 0) {
                    // １行目はタイトル
                    article.setTitle(str);
                } else {
                    body.append(str).append(sep);
                }
                index++;
            }
            article.setContent(body.toString());

            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return article;

    }
}
