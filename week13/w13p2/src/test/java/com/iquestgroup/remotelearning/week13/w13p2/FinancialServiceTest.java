package com.iquestgroup.remotelearning.week13.w13p2;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseAccessDataFileNotFoundException;
import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p2.models.Transaction;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FinancialServiceTest {

  public static final int DRIVER_PATH_INDEX = 0;
  public static final int URL_INDEX = 1;
  public static final int USER_INDEX = 2;
  public static final int PASSWORD_INDEX = 3;
  public static final String FILE_PATH = "src/test/resources/DatabaseAccessData.txt";
  public static final String DATABASE_ACCESS_DATA_EXCEPTION_MESSAGE = "File not found!";
  public static final String STRING_DELIMITER = "-";
  public static final Transaction TRANSACTION_TO_TEST = new Transaction(1, "Pay bills", -15.000, 1);
  public static final String SELECT_QUERY = "SELECT BALANCE FROM CLIENT WHERE ID = ?";
  public static final String BALANCE_FIELD = "balance";
  public static String driverPath;
  public static String url;
  public static String user;
  public static String password;
  private static Connection databaseConnection;
  private FinancialService financialService;
  private ClientDao clientDao;
  private TransactionDao transactionDao;

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
  public void testUpdateDatabase_HappyFlow() {
    int clientId = TRANSACTION_TO_TEST.getClientId();
    double amountOfTransaction = TRANSACTION_TO_TEST.getAmount();
    double balanceBeforeUpdate = 0;
    double balanceAfterUpdate = 0;
    try {
      PreparedStatement preparedStatement = databaseConnection.prepareStatement(SELECT_QUERY);
      preparedStatement.setInt(1, clientId);
      ResultSet firstResultSet = preparedStatement.executeQuery();
      if (firstResultSet.next()) {
        balanceBeforeUpdate = firstResultSet.getDouble(BALANCE_FIELD);
      }
      financialService.updateDatabase(TRANSACTION_TO_TEST);
      ResultSet secondResultSet = preparedStatement.executeQuery();
      if (secondResultSet.next()) {
        balanceAfterUpdate = secondResultSet.getDouble(BALANCE_FIELD);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    assertEquals(balanceBeforeUpdate + amountOfTransaction, balanceAfterUpdate, 0.1);
  }

  @Test(expected = DatabaseException.class)
  public void testUpdateDatabaseClosedConnection() {
    try {
      databaseConnection.close();
      financialService = new FinancialService(databaseConnection, clientDao, transactionDao);
      financialService.updateDatabase(TRANSACTION_TO_TEST);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  private void initData() {
    try {
      Class.forName(driverPath);
      databaseConnection = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    clientDao = new ClientDao(databaseConnection);
    transactionDao = new TransactionDao(databaseConnection);
    financialService = new FinancialService(databaseConnection, clientDao, transactionDao);
  }
}
