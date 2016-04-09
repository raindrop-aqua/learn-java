package com.practice01.service.facade.impl;

import com.practice01.dto.Article;
import com.practice01.service.impl.ArticleFileService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleFileServiceTest {

    @Test
    public void testRead() throws Exception {

        ArticleFileService service = new ArticleFileService();
        Article actual = service.read(2015, 4);
        Article expect = new Article("オブジェクト指向の勉強開始！"
                , "よりよいプログラムを書くために、オブジェクト指向の勉強を開始します。\n"
                + "お客様の要求に答えられるようになることが目的です。\n");
        assertEquals(expect.formatted(), actual.formatted());
    }
}