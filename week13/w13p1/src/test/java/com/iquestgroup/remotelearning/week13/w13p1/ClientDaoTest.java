package com.iquestgroup.remotelearning.week13.w13p1;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.iquestgroup.remotelearning.week13.w13p1.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p1.generator.ClientGenerator;
import com.iquestgroup.remotelearning.week13.w13p1.generator.Generator;
import com.iquestgroup.remotelearning.week13.w13p1.models.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientDaoTest {

  public static final int PREPARED_STATEMENT_FIRST_PARAMETER = 1;
  public static final int PREPARED_STATEMENT_SECOND_PARAMETER = 2;
  public static final int PREPARED_STATEMENT_THIRD_PARAMETER = 3;
  public static final String USERNAME_FIELD = "username";
  public static final double BALANCE = 100.000;
  public static final int NUMBER_OF_CLIENTS = 10;
  public static final int NUMBER_OF_RICH_CLIENTS = 4;
  public static final String SELECT_STATEMENT = "SELECT USERNAME FROM CLIENT WHERE BALANCE = ?";
  public static final String INSERT_STATEMENT = "INSERT INTO CLIENT VALUES(?, ?, ?)";
  public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/mydb";
  public static final String USER = "test";
  public static final String PASSWORD = "test";
  public static final String USERNAME_TO_FIND = "mk13wer";
  public static final String INVALID_USERNAME = "cfg13wa";
  public static final double VALID_BALANCE = 97.14;
  public static final double INVALID_BALANCE = 0;
  private static Connection databaseConnection;
  private ClientDao databaseHandler;

  @BeforeClass
  public static void beforeClassSetup() {
    try {
      Class.forName(DRIVER_PATH);
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    populateDatabase();
  }

  private static void populateDatabase() {
    Generator clientGenerator = new ClientGenerator();
    try {
      PreparedStatement preparedStatement = databaseConnection.prepareStatement(INSERT_STATEMENT);
      for (int index = 0; index < NUMBER_OF_CLIENTS; index++) {
        preparedStatement.setInt(PREPARED_STATEMENT_FIRST_PARAMETER, clientGenerator.getId());
        preparedStatement.setString(PREPARED_STATEMENT_SECOND_PARAMETER, clientGenerator.getUsername());
        preparedStatement.setDouble(PREPARED_STATEMENT_THIRD_PARAMETER, clientGenerator.getBalance());
        preparedStatement.executeUpdate();
      }
    } catch (SQLException exception) {
      System.out.println("Entities are already inserted into database!!!");
    }
  }

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testGetAllClients() {
    List<Client> allClients = databaseHandler.getAllClients();
    assertEquals(NUMBER_OF_CLIENTS, allClients.size());
  }

  @Test
  public void testGetBalanceOfClientByUsername() {
    double clientBalance = databaseHandler.getBalanceOfClientByUsername(USERNAME_TO_FIND);
    assertEquals(VALID_BALANCE, clientBalance, 0);
    try {
      PreparedStatement preparedStatement = databaseConnection.prepareStatement(SELECT_STATEMENT);
      preparedStatement.setDouble(PREPARED_STATEMENT_FIRST_PARAMETER, VALID_BALANCE);
      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.next();
      String actualUsername = resultSet.getString(USERNAME_FIELD);
      assertEquals(USERNAME_TO_FIND, actualUsername);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Test
  public void testGetRichClients() {
    List<Client> richClients = databaseHandler.getRichClients(BALANCE);
    assertEquals(NUMBER_OF_RICH_CLIENTS, richClients.size());
    for (Client currentRichClient : richClients) {
      assertThat(currentRichClient.getBalance(), greaterThan(BALANCE));
    }
  }

  @Test
  public void testGetBalanceOfClientByUsernameInvalidUsername() {
    try {
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    databaseHandler = new ClientDao(databaseConnection);
    double clientBalance = databaseHandler.getBalanceOfClientByUsername(INVALID_USERNAME);
    assertEquals(INVALID_BALANCE, clientBalance, 0);
  }

  @Test(expected = DatabaseException.class)
  public void testGetAllClientsClosedConnection() {
    try {
      databaseConnection.close();
      databaseHandler = new ClientDao(databaseConnection);
      databaseHandler.getAllClients();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Test(expected = DatabaseException.class)
  public void testGetRichClientsClosedConnection() {
    try {
      databaseConnection.close();
      databaseHandler = new ClientDao(databaseConnection);
      databaseHandler.getRichClients(BALANCE);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Test(expected = DatabaseException.class)
  public void testGetBalanceOfClientByUsernameClosedConnection() {
    try {
      databaseConnection.close();
      databaseHandler = new ClientDao(databaseConnection);
      databaseHandler.getBalanceOfClientByUsername(USERNAME_TO_FIND);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  private void initData() {
    try {
      Class.forName(DRIVER_PATH);
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    databaseHandler = new ClientDao(databaseConnection);
  }
}
