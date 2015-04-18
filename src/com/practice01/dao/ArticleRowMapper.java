package com.practice01.dao;

import com.practice01.dto.Article;
import com.practice01.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {
    /**
     *
     * @param rs
     * @param index
     * @return
     * @throws SQLException
     */
    @Override
    public Article mapping(ResultSet rs, int index) throws SQLException {
        Article article = new Article();
        article.setTitle(rs.getString("title"));
        article.setContent(rs.getString("content"));
        return article;
    }
}
