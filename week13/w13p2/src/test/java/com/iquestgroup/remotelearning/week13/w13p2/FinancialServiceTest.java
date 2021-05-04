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
import org.junit.Test;

public class FinancialServiceTest {

  public static final Transaction TRANSACTION_TO_TEST = new Transaction(11, "Pay bills", -15.000, 5);
  public static final String SELECT_QUERY = "SELECT BALANCE FROM CLIENT WHERE ID = ?";
  public static final String BALANCE_FIELD = "balance";
  public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/mydb";
  public static final String USER = "test";
  public static final String PASSWORD = "test";
  private static Connection databaseConnection;
  private FinancialService financialService;
  private ClientDao clientDao;
  private TransactionDao transactionDao;

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

  private void initData(){
    try {
      Class.forName(DRIVER_PATH);
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    clientDao = new ClientDao(databaseConnection);
    transactionDao = new TransactionDao(databaseConnection);
    financialService = new FinancialService(databaseConnection, clientDao, transactionDao);
  }
}
