package com.iquestgroup.remotelearning.week2.p3;

public class Vehicle {
  protected int yearOfFabrication = getYearOfFabrication();
  protected Engine engine = new Engine();
  protected static String vehicleNumber;

  Vehicle(){
    System.out.println("Vehicle()");
    String localVariable = getLocalVariable();
  }

  static{
    vehicleNumber = getVehicleNumber();
  }

  private static String getVehicleNumber(){
    System.out.println("static block of Vehicle - initialized");
    return "22C9FF";
  }

  private String getLocalVariable(){
    System.out.println("local variable of Vehicle - initialized");
    return "local Variable";
  }
  private int getYearOfFabrication(){
    System.out.println("Field of Vehicle - initialized");
    return 1900;
  }

}
