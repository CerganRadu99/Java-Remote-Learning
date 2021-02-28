package com.iquestgroup.remotelearning.week2.p3;

public class Car extends Vehicle{
  protected SteeringWheel steeringWheel = getSteeringWheel();
  protected static int numberOfDoors;

  Car(){
    super();
    System.out.println("Car()");
    String localVariable = getLocalVariable();
  }

  static{
    numberOfDoors = getNumberOfDoors();
  }

  private SteeringWheel getSteeringWheel(){
    System.out.println("Field of Car - initialized");
    return new SteeringWheel();
  }

  private static int getNumberOfDoors(){
    System.out.println("static block of Car - initialized");
    return 4;
  }

  private String getLocalVariable(){
    System.out.println("local variable of Car - initialized");
    return "local variable";
  }
}
