package com.iquestgroup.remotelearning.week13.w13p2.models;

public class Transaction {

  private final int id;
  private final String name;
  private final double amount;
  private final int clientId;

  public Transaction(int id, String name, double amount, int clientId) {
    this.id = id;
    this.name = name;
    this.amount = amount;
    this.clientId = clientId;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getAmount() {
    return amount;
  }

  public int getClientId() {
    return clientId;
  }
}
