package com.iquestgroup.remotelearning.week1.p4;

public class ConnectionManager {

  private int numberOfConnectionObjects;
  private static int index;
  private static Connection[] connectionObjects;
  private static ConnectionManager connectionManager;

  private ConnectionManager(int numberOfConnectionObjects) {
    this.numberOfConnectionObjects = numberOfConnectionObjects;
    connectionObjects = new Connection[numberOfConnectionObjects];
    index = 0;
    createConnectionObjects();
  }

  public static ConnectionManager access(int noConnectionObjects) {
    connectionManager = new ConnectionManager(noConnectionObjects);
    return connectionManager;
  }

  public int getNumberOfConnectionObjects() {
    return numberOfConnectionObjects;
  }

  public static void removeConnectionObject() {
    for (int i = index; i < connectionObjects.length - 1; i++) {
      connectionObjects[i] = connectionObjects[i + 1];
    }
  }

  public static Connection getConnectionObject() {
    try {
      Connection currentConnection = connectionObjects[index++];
      removeConnectionObject();
      return currentConnection;
    } catch (ArrayIndexOutOfBoundsException e) {
      return null;
    }
  }

  private void createConnectionObjects() {
    for (int i = 0; i < getNumberOfConnectionObjects(); i++) {
      connectionObjects[i] = Connection.getConnection();
    }
  }
}