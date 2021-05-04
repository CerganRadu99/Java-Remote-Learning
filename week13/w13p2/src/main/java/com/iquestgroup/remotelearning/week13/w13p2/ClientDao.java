package com.iquestgroup.remotelearning.week13.w13p2;

import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p2.models.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDao {

  private static final String UPDATE_BALANCE_QUERY = "UPDATE CLIENT SET BALANCE = BALANCE + ? WHERE ID = ?";
  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private final Connection databaseConnection;

  public ClientDao(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public void adjustBalanceOfClient(Transaction recordedTransaction) {
    try (PreparedStatement updateBalance = databaseConnection.prepareStatement(UPDATE_BALANCE_QUERY)) {
      updateBalance.setDouble(1, recordedTransaction.getAmount());
      updateBalance.setInt(2, recordedTransaction.getClientId());
      updateBalance.executeUpdate();
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
