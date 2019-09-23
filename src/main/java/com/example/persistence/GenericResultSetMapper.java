package com.example.persistence;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GenericResultSetMapper implements RowMapper<Map<String, Object>> {

  @Override
  public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
    return mapRowIntoMap(resultSet);
  }

  private static Map<String, Object> mapRowIntoMap(ResultSet resultSet) throws SQLException {
    Map<String, Object> columnValueMap = new HashMap<>();
    ResultSetMetaData metaData = resultSet.getMetaData();
    final int columnCount = metaData.getColumnCount();

    for (int i = 1; i <= columnCount; i++) {
      String columnLabel = metaData.getColumnLabel(i);
      Object columnValue = resultSet.getObject(columnLabel);
      columnValueMap.put(columnLabel, columnValue);
    }

    return columnValueMap;
  }
}
