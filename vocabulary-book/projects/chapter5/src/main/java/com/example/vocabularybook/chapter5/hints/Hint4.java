package com.example.vocabularybook.chapter5.hints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hint4 {
    public static void main(String[] args) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = stmt.executeQuery();
        rs.next();  // レコードのポイント位置をはじめの1件目に合わせる <1>
        String result = rs.getString("word2");  // word2 フィールドの値を読み取る　<2>
    }

    private static Connection getConnection() {
        return null;
    }
}
