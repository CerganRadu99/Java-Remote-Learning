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

public class ClientDao {

  private static final String ALL_CLIENTS_QUERY = "SELECT * FROM CLIENT";
  private static final String BALANCE_BY_USERNAME_QUERY = "SELECT BALANCE FROM CLIENT WHERE USERNAME = ?";
  private static final String RICH_CLIENTS_QUERY = "SELECT * FROM CLIENT WHERE BALANCE > ?";
  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private static final String BALANCE_FIELD = "balance";
  private static final String ID_FIELD = "id";
  private static final String USERNAME_FIELD = "username";
  private final Connection databaseConnection;

  public ClientDao(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public List<Client> getAllClients() {
    try (Statement statement = databaseConnection.createStatement()) {
      return executeQuery(ALL_CLIENTS_QUERY, statement);
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }

  public double getBalanceOfClientByUsername(String username) {
    double clientBalance;
    try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(BALANCE_BY_USERNAME_QUERY)) {
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

  public List<Client> getRichClients(double balance) {
    try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(RICH_CLIENTS_QUERY)) {
      preparedStatement.setDouble(1, balance);
      return executeQuery(RICH_CLIENTS_QUERY, preparedStatement);
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }

  private List<Client> executeQuery(String query, Statement statement) {
    List<Client> clients = new ArrayList<>();
    try {
      ResultSet resultSet;
      if (statement instanceof PreparedStatement) {
        PreparedStatement preparedStatement = (PreparedStatement) statement;
        resultSet = preparedStatement.executeQuery();
      } else {
        resultSet = statement.executeQuery(query);
      }
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
}
