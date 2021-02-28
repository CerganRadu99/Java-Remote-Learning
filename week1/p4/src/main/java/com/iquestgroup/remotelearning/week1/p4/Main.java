package com.iquestgroup.remotelearning.week1.p4;

public class Main {

  public static void main(String[] args) {
    if (args.length > 0) {
      try {
        ConnectionManager connectionManager = ConnectionManager.access(Integer.parseInt(args[0]));
        for (int i = 0; i <= Integer.parseInt(args[0]); i++) {
          Object connection = connectionManager.getConnectionObject();
          if (i == connectionManager.getNumberOfConnectionObjects()) {
            if (connection == null) {
              System.out.println("Test - Successful");
            } else {
              System.out.println("Test - Failed");
            }
          }
        }
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
  }
}
