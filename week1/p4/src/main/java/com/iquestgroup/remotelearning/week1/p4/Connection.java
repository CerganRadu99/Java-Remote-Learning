package com.iquestgroup.remotelearning.week1.p4;

class Connection {

  private Connection() {
  }

  static Connection getConnection() {
    return new Connection();
  }

}
