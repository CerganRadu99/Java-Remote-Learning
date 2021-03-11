package com.iquestgroup.remotelearning.week2.p3.models;


public class Vehicle {

  private int yearOfFabrication = getYearOfFabrication();
  private Engine engine = new Engine();
  private static String vehicleNumber = getVehicleNumber();

  public Vehicle() {
    System.out.println("Vehicle()");
    String localVariable = getLocalVariable();
  }

  static {
    System.out.println("static block of Vehicle - called");
  }

  {
    System.out.println("anonymous block of Vehicle - called");
  }

  private static String getVehicleNumber() {
    System.out.println("static field of Vehicle - initialized");
    return "22C9FF";
  }

  private String getLocalVariable() {
    System.out.println("local variable of Vehicle - initialized");
    return "local Variable";
  }

  private int getYearOfFabrication() {
    System.out.println("Field of Vehicle - initialized");
    return 1900;
  }

}
