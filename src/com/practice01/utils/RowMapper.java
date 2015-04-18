package com.practice01.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapping(ResultSet rs, int index) throws SQLException;
}
