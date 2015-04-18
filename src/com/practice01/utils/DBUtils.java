package com.practice01.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DBにアクセスするためのクラス
 */
public class DBUtils {

    /**
     * mydata.dbへのDB接続を作成
     * @return DB接続
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        // 接続文字列
        String connectionString
                = "jdbc:sqlite:"
                + FileUtils.getFullPath("practice01/mydata.db");
        return DriverManager.getConnection(connectionString);
    }


    /**
     * クエリを発行して結果を抽出する
     * SpringFrameworkのJdbcTemplateクラスを真似て作成しました
     *
     * @param <T> ジェネリクスクラス
     * @param sql SQL
     * @param params SQL引数
     * @param mapper マッピングクラス
     * @return 抽出したデータのリスト
     * @throws SQLException
     */
    public static <T> List<T> query(String sql, List<String> params, RowMapper<T> mapper) throws SQLException {
        ArrayList<T> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;

        try {
            // DB接続作成
            conn = getConnection();
            // SQL設定
            st = conn.prepareStatement(sql);
            // SQLパラメータ設定
            int index = 1;
            for (Object param : params) {
                st.setString(index, (String) param);
                index++;
            }
            // クエリ実行
            ResultSet rs = st.executeQuery();
            int rowIndex = 0;
            while (rs.next()) {
                // 各DAOのmapperを利用してDTOに値を設定する
                list.add(mapper.mapping(rs, rowIndex));
                rowIndex++;
            }
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
