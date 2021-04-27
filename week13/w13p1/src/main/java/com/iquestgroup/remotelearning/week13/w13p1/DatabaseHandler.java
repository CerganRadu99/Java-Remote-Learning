package com.iquestgroup.remotelearning.week13.w13p1;

import com.iquestgroup.remotelearning.week13.w13p1.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p1.models.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private static final String BALANCE_FIELD = "balance";
  private static final String ID_FIELD = "id";
  private static final String USERNAME_FIELD = "username";
  private final Connection databaseConnection;

  public DatabaseHandler(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public List<Client> getAllClients(String query) {
    Statement statement = createStatement();
    return executeQuery(query, statement);
  }

  public double getBalanceOfAClientByUsername(String username, String query) {
    double clientBalance;
    try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
      preparedStatement.setString(1, username);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        clientBalance = resultSet.getDouble(BALANCE_FIELD);
      } else {
        clientBalance = 0;
      }
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
    return clientBalance;
  }

  public List<Client> getRichClients(String query) {
    Statement statement = createStatement();
    return executeQuery(query, statement);
  }

  private List<Client> executeQuery(String query, Statement statement) {
    List<Client> clients = new ArrayList<>();
    try {
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        int clientID = resultSet.getInt(ID_FIELD);
        String clientUsername = resultSet.getString(USERNAME_FIELD);
        double clientBalance = resultSet.getDouble(BALANCE_FIELD);
        clients.add(new Client(clientID, clientUsername, clientBalance));
      }
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
    return clients;
  }

  private Statement createStatement() {
    try {
      return databaseConnection.createStatement();
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
