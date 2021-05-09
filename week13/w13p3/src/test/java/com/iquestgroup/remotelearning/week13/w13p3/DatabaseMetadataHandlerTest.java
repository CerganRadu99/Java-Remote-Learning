package com.iquestgroup.remotelearning.week13.w13p3;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week13.w13p3.exception.DatabaseAccessDataFileNotFoundException;
import com.iquestgroup.remotelearning.week13.w13p3.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p3.models.TableColumn;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseMetadataHandlerTest {

  public static final int DRIVER_PATH_INDEX = 0;
  public static final int URL_INDEX = 1;
  public static final int USER_INDEX = 2;
  public static final int PASSWORD_INDEX = 3;
  public static final String FILE_PATH = "src/test/resources/DatabaseAccessData.txt";
  public static final String STRING_DELIMITER = "-";
  public static final String DATABASE_ACCESS_DATA_EXCEPTION_MESSAGE = "File not found!";
  public static final List<String> DATABASE_TABLES = new ArrayList<>(Arrays.asList("client", "transaction"));
  public static final Map<String, List<TableColumn>> TABLES;
  public static final int NUMBER_OF_TABLES = 2;
  public static final String DATABASE_NAME = "mydb";
  public static String driverPath;
  public static String url;
  public static String user;
  public static String password;
  private static Connection databaseConnection;

  static {
    List<TableColumn> clientColumns = new ArrayList<>();
    clientColumns.add(new TableColumn("id", "INT", 10));
    clientColumns.add(new TableColumn("username", "VARCHAR", 20));
    clientColumns.add(new TableColumn("balance", "DECIMAL", 13));
    List<TableColumn> transactionColumns = new ArrayList<>();
    transactionColumns.add(new TableColumn("id", "INT", 10));
    transactionColumns.add(new TableColumn("name", "VARCHAR", 20));
    transactionColumns.add(new TableColumn("amount", "DECIMAL", 13));
    transactionColumns.add(new TableColumn("client_id", "INT", 10));
    TABLES = new HashMap<>();
    TABLES.put("client", clientColumns);
    TABLES.put("transaction", transactionColumns);
  }

  private DatabaseMetadataHandler databaseMetadataHandler;

  @BeforeClass
  public static void setupBeforeClass() {
    readDatabaseAccessData();
  }

  private static void readDatabaseAccessData() {
    List<String> databaseAccessData = new ArrayList<>();
    File databaseAccessDataFile = new File(FILE_PATH);
    try {
      Scanner fileReader = new Scanner(databaseAccessDataFile);
      while (fileReader.hasNextLine()) {
        String currentData = fileReader.nextLine();
        databaseAccessData.add(currentData.substring(currentData.lastIndexOf(STRING_DELIMITER) + 1));
      }
      setDatabaseAccesData(databaseAccessData);
    } catch (FileNotFoundException exception) {
      throw new DatabaseAccessDataFileNotFoundException(DATABASE_ACCESS_DATA_EXCEPTION_MESSAGE);
    }
  }

  private static void setDatabaseAccesData(List<String> databaseAccessData) {
    driverPath = databaseAccessData.get(DRIVER_PATH_INDEX);
    url = databaseAccessData.get(URL_INDEX);
    user = databaseAccessData.get(USER_INDEX);
    password = databaseAccessData.get(PASSWORD_INDEX);
  }

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
      Class.forName(driverPath);
      databaseConnection = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    databaseMetadataHandler = new DatabaseMetadataHandler(databaseConnection);
  }
}
