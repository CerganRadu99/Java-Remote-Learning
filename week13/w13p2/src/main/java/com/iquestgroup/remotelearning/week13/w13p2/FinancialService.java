package com.iquestgroup.remotelearning.week13.w13p2;

import com.iquestgroup.remotelearning.week13.w13p2.exception.DatabaseException;
import com.iquestgroup.remotelearning.week13.w13p2.models.Transaction;
import java.sql.Connection;
import java.sql.SQLException;

public class FinancialService {

  private final ClientDao clientDao;
  private final TransactionDao transactionDao;
  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private final Connection databaseConnection;

  public FinancialService(Connection databaseConnection, ClientDao clientDao, TransactionDao transactionDao) {
    this.databaseConnection = databaseConnection;
    this.clientDao = clientDao;
    this.transactionDao = transactionDao;
  }

  public void updateDatabase(Transaction transaction) {
    try {
      databaseConnection.setAutoCommit(false);
      transactionDao.recordTransaction(transaction);
      clientDao.adjustBalanceOfClient(transaction);
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
}
