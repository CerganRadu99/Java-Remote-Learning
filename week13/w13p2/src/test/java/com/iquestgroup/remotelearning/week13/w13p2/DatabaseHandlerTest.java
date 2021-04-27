package com.iquestgroup.remotelearning.week13.w13p2;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p2.models.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseHandlerTest {

  public static final Transaction INVALID_QUERIES_TRANSACTION = new Transaction(10, "Receive salary", 20.000, 7);
  public static final Transaction TRANSACTION_TO_TEST = new Transaction(9, "Pay bills", -15.000, 6);
  public static final String VALID_RECORD_TRANSACTION_QUERY = "INSERT INTO TRANSACTION VALUES(?, ?, ?, ?)";
  public static final String INVALID_RECORD_TRANSACTION_QUERY = "INSERT INT TRANSACTION VALUES(?, ?, ?, ?)";
  public static final String VALID_UPDATE_BALANCE_QUERY = "UPDATE CLIENT SET BALANCE = BALANCE + ? WHERE ID = ?";
  public static final String INVALID_UPDATE_BALANCE_QUERY = "UPDATE CLIENT SE BALANCE = BALANCE + ? WHERE ID = ?";
  public static final String SELECT_QUERY = "SELECT BALANCE FROM CLIENT WHERE ID = ?";
  public static final String BALANCE_FIELD = "balance";
  public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/mydb";
  public static final String USER = "test";
  public static final String PASSWORD = "test";
  private static Connection databaseConnection;
  private DatabaseHandler databaseHandler;

  @BeforeClass
  public static void beforeClassSetup() {
    try {
      Class.forName(DRIVER_PATH);
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Before
  public void setup() {
    databaseHandler = new DatabaseHandler(databaseConnection, VALID_RECORD_TRANSACTION_QUERY, VALID_UPDATE_BALANCE_QUERY);
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
      databaseHandler.updateDatabase(TRANSACTION_TO_TEST);
      ResultSet secondResultSet = preparedStatement.executeQuery();
      if (secondResultSet.next()) {
        balanceAfterUpdate = secondResultSet.getDouble(BALANCE_FIELD);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    assertEquals(balanceBeforeUpdate + amountOfTransaction, balanceAfterUpdate, 0);
  }

  @Test(expected = DatabaseException.class)
  public void testUpdateDatabaseClosedConnection() {
    try {
      databaseConnection.close();
      databaseHandler = new DatabaseHandler(databaseConnection, VALID_RECORD_TRANSACTION_QUERY, VALID_UPDATE_BALANCE_QUERY);
      databaseHandler.updateDatabase(TRANSACTION_TO_TEST);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Test(expected = DatabaseException.class)
  public void testUpdateDatabaseInvalidRecordTransactionQuery() {
    databaseHandler.setRecordTransactionQuery(INVALID_RECORD_TRANSACTION_QUERY);
    databaseHandler.updateDatabase(INVALID_QUERIES_TRANSACTION);
  }

  @Test(expected = DatabaseException.class)
  public void testUpdateDatabaseInvalidUpdateBalanceQuery() {
    databaseHandler.setUpdateBalanceQuery(INVALID_UPDATE_BALANCE_QUERY);
    databaseHandler.updateDatabase(INVALID_QUERIES_TRANSACTION);
  }
}
