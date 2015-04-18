package com.practice01.dao;

import com.practice01.dto.Article;
import com.practice01.utils.DBUtils;
import com.practice01.utils.RowMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

    public Article readByYearMonth(int year, int month) throws SQLException {
        // SQLを作成
        String sql = "select * from Article where year = ? and month = ?";
        // パラメータを作成
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(year));
        params.add(String.valueOf(month));
        // row mapperを作成
        RowMapper<Article> mapper = new ArticleRowMapper();

        // クエリを実行
        List<Article> list = DBUtils.query(sql, params, mapper);

        // データが抽出できた場合
        if (list.size() > 0) {
            return list.get(0);
        }
        return new Article();
    }
}
