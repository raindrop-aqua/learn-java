package com.practice01.service.impl;

import com.practice01.dao.ArticleDAO;
import com.practice01.dto.Article;
import com.practice01.service.ArticleService;

import java.sql.SQLException;

/**
 * DBに格納された記事を扱うクラス
 */
public class ArticleDBService implements ArticleService {
    @Override
    public Article read(int year, int month) {
        try {
            return new ArticleDAO().readByYearMonth(year, month);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Article();
    }
}
