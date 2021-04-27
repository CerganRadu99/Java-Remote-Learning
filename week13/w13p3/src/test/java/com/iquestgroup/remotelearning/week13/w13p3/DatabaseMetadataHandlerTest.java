package com.iquestgroup.remotelearning.week13.w13p3;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week13.w13p3.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p3.models.TableColumn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class DatabaseMetadataHandlerTest {

  public static final List<String> DATABASE_TABLES = new ArrayList<>(Arrays.asList("client", "transaction"));
  public static final Map<String, List<TableColumn>> TABLES;
  public static final int NUMBER_OF_TABLES = 2;
  public static final String DATABASE_NAME = "mydb";
  public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/mydb";
  public static final String USER = "test";
  public static final String PASSWORD = "test";
  private static Connection databaseConnection;

  static {
    List<TableColumn> clientColumns = new ArrayList<>();
    clientColumns.add(new TableColumn("id", "INT", 10));
    clientColumns.add(new TableColumn("username", "VARCHAR", 45));
    clientColumns.add(new TableColumn("balance", "DECIMAL", 13));
    List<TableColumn> transactionColumns = new ArrayList<>();
    transactionColumns.add(new TableColumn("id", "INT", 10));
    transactionColumns.add(new TableColumn("name", "VARCHAR", 45));
    transactionColumns.add(new TableColumn("amount", "DECIMAL", 13));
    transactionColumns.add(new TableColumn("client_id", "INT", 10));
    TABLES = new HashMap<>();
    TABLES.put("client", clientColumns);
    TABLES.put("transaction", transactionColumns);
  }

  private DatabaseMetadataHandler databaseMetadataHandler;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testGetDatabaseName_HappyFlow() {
    String actualDatabaseName = databaseMetadataHandler.getDatabaseName();
    assertEquals(DATABASE_NAME, actualDatabaseName);
  }

  @Test(expected = DatabaseException.class)
  public void testGetMetaDataClosedConnection() {
    try {
      databaseConnection.close();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    databaseMetadataHandler = new DatabaseMetadataHandler(databaseConnection);
  }

  @Test
  public void testGetDatabaseTables_HappyFlow() {
    List<String> actualDatabaseTables = databaseMetadataHandler.getDatabaseTables();
    assertEquals(NUMBER_OF_TABLES, actualDatabaseTables.size());
    for (int tableIndex = 0; tableIndex < NUMBER_OF_TABLES; tableIndex++) {
      assertEquals(DATABASE_TABLES.get(tableIndex), actualDatabaseTables.get(tableIndex));
    }
  }

  @Test
  public void testGetDatabaseColumns_HappyFlow() {
    List<String> databaseTables = databaseMetadataHandler.getDatabaseTables();
    HashMap<String, List<TableColumn>> tables = (HashMap<String, List<TableColumn>>) databaseMetadataHandler.getDatabaseColumns(databaseTables);
    assertEquals(NUMBER_OF_TABLES, tables.size());
    assertEquals(TABLES, tables);
  }

  private void initData() {
    try {
      Class.forName(DRIVER_PATH);
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    databaseMetadataHandler = new DatabaseMetadataHandler(databaseConnection);
  }
}
