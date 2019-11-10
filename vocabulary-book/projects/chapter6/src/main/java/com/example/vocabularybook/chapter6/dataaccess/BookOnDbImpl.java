package com.example.vocabularybook.chapter6.dataaccess;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookOnDbImpl implements BookAccessor {
    // Database接続<1>
    private DataSource ds;

    // dataSourceプロパティへのアクセサ<2>
    public DataSource getDs() {
        return ds;
    }

    // dataSourceプロパティへのアクセサ<3>
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    private Connection getConnection() throws SQLException {
        // データベース接続情報を外部より取得するように変更<4>
        return getDs().getConnection();
    }

    @Override
    public String findBy(String queryWord) {
        String result = null;
        String sql = "select * from book where word1 = ?";

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, queryWord);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getString("word2");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void add(String newWord, String newTranslatedWord) {
        String sql = "insert into book (word1, word2) values (?, ?)";

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, newWord);
            stmt.setString(2, newTranslatedWord);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String deleteWord) {
        String sql = "delete from book where word1 = ?";

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, deleteWord);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BookOnDbImpl().create();
    }

    private void create() {
        String sql = "create table book (word1 char(20), word2 char(20))";

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
