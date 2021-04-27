package com.iquestgroup.remotelearning.week13.w13p1.generator;

public class ClientGenerator implements Generator {

  private static final String[] USERNAMES;
  private static final Double[] BALANCE;

  static {
    USERNAMES = new String[]{"alexgcc", "mk13wer", "vld991zc", "radu77zxw", "mirc90ea", "velo113", "mark9912", "rob33vv", "cip12shadow", "sor11in"};
    BALANCE = new Double[]{88.000, 97.135, 102.111, 103.999, 99.200, 75.888, 120.000, 133.133, 90.77, 85.789};
  }

  private int id = 0;
  private int usernameIndex = 0;
  private int balanceIndex = 0;

  @Override
  public int getId() {
    return ++id;
  }

  @Override
  public String getUsername() {
    return USERNAMES[usernameIndex++];
  }

  @Override
  public double getBalance() {
    return BALANCE[balanceIndex++];
  }
}
