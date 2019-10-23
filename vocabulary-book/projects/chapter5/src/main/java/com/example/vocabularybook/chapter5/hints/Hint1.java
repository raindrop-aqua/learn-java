package com.example.vocabularybook.chapter5.hints;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hint1 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:c:/data/book";    // 接続文字列 <1>
        String user = "sa";                     // ユーザー <2>
        String password = "";                   // パスワード <3>
        Connection con = DriverManager.getConnection(url, user, password);
    }
}
