package com.iquestgroup.remotelearning.week4.w4p1.models;

import java.util.List;

public class DispatchOperator implements Person, Dispatcher {

  private final String name;
  private final List<Driver> drivers;
  private static final int BEST_AVAILABLE_TAXI = 0;

  public DispatchOperator(String name, List<Driver> drivers) {
    this.name = name;
    this.drivers = drivers;
  }

  @Override
  public void dispatch(String location) {
    getBestAvailableTaxi(location).goToAddress(location);
  }

  @Override
  public void eat() {
    System.out.println("Operator " + name + " eats");
  }

  private Driver getBestAvailableTaxi(String location) {
    return drivers.get(BEST_AVAILABLE_TAXI);
  }
}
