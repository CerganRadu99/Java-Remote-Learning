package com.iquestgroup.remotelearning.week13.w13p2;

import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p2.models.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {

  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private final Connection databaseConnection;
  private String recordTransactionQuery;
  private String updateBalanceQuery;

  public DatabaseHandler(Connection databaseConnection, String recordTransactionQuery, String updateBalanceQuery) {
    this.databaseConnection = databaseConnection;
    this.recordTransactionQuery = recordTransactionQuery;
    this.updateBalanceQuery = updateBalanceQuery;
  }

  public void setRecordTransactionQuery(String recordTransactionQuery) {
    this.recordTransactionQuery = recordTransactionQuery;
  }

  public void setUpdateBalanceQuery(String updateBalanceQuery) {
    this.updateBalanceQuery = updateBalanceQuery;
  }

  public void updateDatabase(Transaction transaction) {
    try {
      databaseConnection.setAutoCommit(false);
      recordTransaction(transaction);
      adjustBalanceOfClient(transaction);
      databaseConnection.commit();
      databaseConnection.setAutoCommit(true);
    } catch (SQLException exception) {
      try {
        databaseConnection.rollback();
      } catch (SQLException excep) {
        throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
      }
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }

  private void recordTransaction(Transaction transactionToRecord) {
    try (PreparedStatement recordTransaction = databaseConnection.prepareStatement(recordTransactionQuery)) {
      recordTransaction.setInt(1, transactionToRecord.getId());
      recordTransaction.setString(2, transactionToRecord.getName());
      recordTransaction.setDouble(3, transactionToRecord.getAmount());
      recordTransaction.setInt(4, transactionToRecord.getClientId());
      recordTransaction.executeUpdate();
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }

  private void adjustBalanceOfClient(Transaction recordedTransaction) {
    try (PreparedStatement updateBalance = databaseConnection.prepareStatement(updateBalanceQuery)) {
      updateBalance.setDouble(1, recordedTransaction.getAmount());
      updateBalance.setInt(2, recordedTransaction.getClientId());
      updateBalance.executeUpdate();
    } catch (SQLException exception) {
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
