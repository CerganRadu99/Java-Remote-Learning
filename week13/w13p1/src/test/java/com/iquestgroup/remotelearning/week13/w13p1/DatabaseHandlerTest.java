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
import java.sql.SQLException;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseHandlerTest {

  public static final String VALID_ALL_CLIENTS_QUERY = "SELECT * FROM CLIENT";
  public static final String INVALID_ALL_CLIENTS_QUERY = "SELECT * FRO CLIENT";
  public static final String VALID_BALANCE_BY_USERNAME_QUERY = "SELECT BALANCE FROM CLIENT WHERE USERNAME = ?";
  public static final String INVALID_BALANCE_BY_USERNAME_QUERY = "SELECT BALANCE FRO CLIENT WHERE USERNAME = ?";
  public static final String VALID_RICH_CLIENTS_QUERY = "SELECT * FROM CLIENT WHERE BALANCE > 100.000";
  public static final int NUMBER_OF_CLIENTS = 10;
  public static final int NUMBER_OF_RICH_CLIENTS = 4;
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
  private DatabaseHandler databaseHandler;

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
        preparedStatement.setInt(1, clientGenerator.getId());
        preparedStatement.setString(2, clientGenerator.getUsername());
        preparedStatement.setDouble(3, clientGenerator.getBalance());
        preparedStatement.executeUpdate();
      }
    } catch (SQLException exception) {
      System.out.println("Entities are already inserted into database!!!");
    }
  }

  @Before
  public void setup() {
    databaseHandler = new DatabaseHandler(databaseConnection);
  }

  @Test
  public void testGetAllClients() {
    List<Client> allClients = databaseHandler.getAllClients(VALID_ALL_CLIENTS_QUERY);
    assertEquals(NUMBER_OF_CLIENTS, allClients.size());
  }

  @Test(expected = DatabaseException.class)
  public void testGelAllClientsInvalidQuery() {
    databaseHandler.getAllClients(INVALID_ALL_CLIENTS_QUERY);
  }

  @Test(expected = DatabaseException.class)
  public void testGetAllClientsClosedConnection() {
    try {
      databaseConnection.close();
      databaseHandler = new DatabaseHandler(databaseConnection);
      databaseHandler.getAllClients(VALID_ALL_CLIENTS_QUERY);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Test
  public void testGetBalanceOfAClientByUsername() {
    double clientBalance = databaseHandler.getBalanceOfAClientByUsername(USERNAME_TO_FIND, VALID_BALANCE_BY_USERNAME_QUERY);
    assertEquals(VALID_BALANCE, clientBalance, 0);
  }

  @Test
  public void testGetBalanceOfAClientByUsernameInvalidUsername() {
    try {
      databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    databaseHandler = new DatabaseHandler(databaseConnection);
    double clientBalance = databaseHandler.getBalanceOfAClientByUsername(INVALID_USERNAME, VALID_BALANCE_BY_USERNAME_QUERY);
    assertEquals(INVALID_BALANCE, clientBalance, 0);
  }

  @Test(expected = DatabaseException.class)
  public void testGetBalanceOfAClientByUsernameInvalidQuery() {
    databaseHandler.getBalanceOfAClientByUsername(USERNAME_TO_FIND, INVALID_BALANCE_BY_USERNAME_QUERY);
  }

  @Test
  public void testGetRichClients() {
    List<Client> richClients = databaseHandler.getRichClients(VALID_RICH_CLIENTS_QUERY);
    assertEquals(NUMBER_OF_RICH_CLIENTS, richClients.size());
    for (Client currentRichClient : richClients) {
      assertThat(currentRichClient.getBalance(), greaterThan(100.000));
    }
  }
}
