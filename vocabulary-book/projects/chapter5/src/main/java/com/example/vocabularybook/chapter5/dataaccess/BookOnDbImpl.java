package com.example.vocabularybook.chapter5.dataaccess;

import java.sql.*;

public class BookOnDbImpl implements BookAccessor {

    private Connection getConnection() throws SQLException {
        String home = System.getProperty("user.dir");
        String url = "jdbc:h2:" + home + "/data/book";
        String user = "sa";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(true);
        return con;
    }

    @Override
    public String findBy(final String queryWord) {
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
    public void add(final String newWord, final String newTranslatedWord) {
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
    public void delete(final String deleteWord) {
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
