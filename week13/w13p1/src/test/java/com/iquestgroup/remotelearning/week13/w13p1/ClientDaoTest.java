package com.iquestgroup.remotelearning.week13.w13p1;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.iquestgroup.remotelearning.week13.w13p1.exception.DatabaseAccessDataFileNotFoundException;
import com.iquestgroup.remotelearning.week13.w13p1.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p1.models.Client;
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

public class ClientDaoTest {

  public static final int PREPARED_STATEMENT_FIRST_PARAMETER = 1;
  public static final String USERNAME_FIELD = "username";
  public static final double BALANCE = 100.000;
  public static final int NUMBER_OF_CLIENTS = 10;
  public static final int NUMBER_OF_RICH_CLIENTS = 4;
  public static final String SELECT_STATEMENT = "SELECT USERNAME FROM CLIENT WHERE BALANCE = ?";
  public static final String USERNAME_TO_FIND = "mk13wer";
  public static final String INVALID_USERNAME = "cfg13wa";
  public static final double VALID_BALANCE = 97.14;
  public static final double INVALID_BALANCE = 0;
  public static final String FILE_PATH = "src/test/resources/DatabaseAccessData.txt";
  public static final int DRIVER_PATH_INDEX = 0;
  public static final int URL_INDEX = 1;
  public static final int USER_INDEX = 2;
  public static final int PASSWORD_INDEX = 3;
  public static final String DATABASE_ACCESS_DATA_EXCEPTION_MESSAGE = "File not found!";
  public static final String STRING_DELIMITER = "-";
  public static String driverPath;
  public static String url;
  public static String user;
  public static String password;
  private static Connection databaseConnection;
  private ClientDao databaseHandler;

  @BeforeClass
  public static void beforeClassSetup() {
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
      databaseConnection = DriverManager.getConnection(url, user, password);
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
      Class.forName(driverPath);
      databaseConnection = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
    databaseHandler = new ClientDao(databaseConnection);
  }
}
