package com.iquestgroup.remotelearning.week2.w2p3.models;

public class Car extends Vehicle {

  private SteeringWheel steeringWheel = getSteeringWheel();
  private static final int numberOfDoors = getNumberOfDoors();

  public Car() {
    super();
    System.out.println("Car()");
    String localVariable = getLocalVariable();
  }

  static {
    System.out.println("static block of Car - called");
  }

  {
    System.out.println("anonymous block of Car - called");
  }

  private SteeringWheel getSteeringWheel() {
    System.out.println("Field of Car - initialized");
    return new SteeringWheel();
  }

  private static int getNumberOfDoors() {
    System.out.println("static field of Car - initialized");
    return 4;
  }

  private String getLocalVariable() {
    System.out.println("local variable of Car - initialized");
    return "local variable";
  }
}
