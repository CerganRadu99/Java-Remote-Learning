package com.iquestgroup.remotelearning.week1.p4;

import com.iquestgroup.remotelearning.week1.p4.models.ConnectionManager;

public class Main {

  public static void main(String[] args) {
    if (args.length > 0) {
      try {
        ConnectionManager connectionManager = ConnectionManager.access(Integer.parseInt(args[0]));
        for (int index = 0; index <= Integer.parseInt(args[0]); index++) {
          Object connection = connectionManager.getConnectionObject();
          if (index == connectionManager.getNumberOfConnectionObjects()) {
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
