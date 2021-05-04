package com.iquestgroup.remotelearning.week13.w13p2;

import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p2.models.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDao {

  private static final String RECORD_TRANSACTION_QUERY = "INSERT INTO TRANSACTION VALUES(?, ?, ?, ?)";
  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private final Connection databaseConnection;

  public TransactionDao(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public void recordTransaction(Transaction transactionToRecord) {
    try (PreparedStatement recordTransaction = databaseConnection.prepareStatement(RECORD_TRANSACTION_QUERY)) {
      recordTransaction.setInt(1, transactionToRecord.getId());
      recordTransaction.setString(2, transactionToRecord.getName());
      recordTransaction.setDouble(3, transactionToRecord.getAmount());
      recordTransaction.setInt(4, transactionToRecord.getClientId());
      recordTransaction.executeUpdate();
    } catch (SQLException exception) {
      exception.printStackTrace();
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
