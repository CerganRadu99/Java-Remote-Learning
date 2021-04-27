package com.iquestgroup.remotelearning.week13.w13p1.models;

public class Client {

  private final int id;
  private final String username;
  private final double balance;

  public Client(int id, String username, double balance) {
    this.id = id;
    this.username = username;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }
}
