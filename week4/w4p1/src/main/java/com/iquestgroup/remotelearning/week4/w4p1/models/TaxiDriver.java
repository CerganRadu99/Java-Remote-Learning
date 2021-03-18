package com.iquestgroup.remotelearning.week4.w4p1.models;


public class TaxiDriver implements Person, Driver {

  private final String name;

  public TaxiDriver(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void sleep() {
    System.out.println("Driver " + name + " sleeps");
  }

  @Override
  public String getCurrentLocation() {
    return "mock location";
  }

  /**
   * Triggers depart to address
   *
   * @return estimated time of arrival (minutes)
   */
  @Override
  public int goToAddress(String address) {
    System.out.println("Driver " + name + " goes to " + address);
    return 2;
  }

  @Override
  public void eat() {
    System.out.println("Driver " + name + " eats");
  }
}