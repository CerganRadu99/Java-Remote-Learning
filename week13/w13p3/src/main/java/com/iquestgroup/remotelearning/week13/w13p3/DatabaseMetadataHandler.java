package com.iquestgroup.remotelearning.week13.w13p3;

import com.iquestgroup.remotelearning.week13.w13p3.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p3.models.TableColumn;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseMetadataHandler {

  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private static final String TABLE_NAME = "TABLE_NAME";
  private static final String COLUMN_NAME = "COLUMN_NAME";
  private static final String TYPE_NAME = "TYPE_NAME";
  private static final String COLUMN_SIZE = "COLUMN_SIZE";

  private static final String[] TYPE_OF_TABLES = {"TABLE"};
  private final DatabaseMetaData databaseMetaData;
  private final Connection databaseConnection;

  public DatabaseMetadataHandler(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
    databaseMetaData = getMetaData();
  }

  public String getDatabaseName() {
    String databaseName;
    try {
      databaseName = databaseConnection.getCatalog();
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
    return databaseName;
  }

  public List<String> getDatabaseTables() {
    List<String> databaseTables = new ArrayList<>();
    try {
      ResultSet resultSet = databaseMetaData.getTables(databaseConnection.getCatalog(), null, null, TYPE_OF_TABLES);
      while (resultSet.next()) {
        databaseTables.add(resultSet.getString(TABLE_NAME));
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
    return databaseTables;
  }

  public Map<String, List<TableColumn>> getDatabaseColumns(List<String> databaseTables) {
    Map<String, List<TableColumn>> tables = new HashMap<>();
    for (String currentTable : databaseTables) {
      List<TableColumn> tableColumns = new ArrayList<>();
      try {
        ResultSet resultSet = databaseMetaData.getColumns(databaseConnection.getCatalog(), null, currentTable, null);
        while (resultSet.next()) {
          String columnName = resultSet.getString(COLUMN_NAME);
          String columnType = resultSet.getString(TYPE_NAME);
          int columnSize = resultSet.getInt(COLUMN_SIZE);
          tableColumns.add(new TableColumn(columnName, columnType, columnSize));
        }
        tables.put(currentTable, tableColumns);
      } catch (SQLException exception) {
        throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
      }
    }
    return tables;
  }

  private DatabaseMetaData getMetaData() {
    try {
      return this.databaseConnection.getMetaData();
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
