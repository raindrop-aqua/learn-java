package com.example.vocabularybook.chapter5.hints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hint3 {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from book where word1 = ?";
        String queryWord = "apple";

        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, queryWord);
        ResultSet rs = stmt.executeQuery();
    }

    private static Connection getConnection() {
        return null;
    }
}
