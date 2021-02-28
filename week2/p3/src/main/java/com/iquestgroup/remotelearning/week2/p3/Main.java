package com.iquestgroup.remotelearning.week2.p3;

import com.iquestgroup.remotelearning.week2.p3.models.Car;
import com.iquestgroup.remotelearning.week2.p3.models.Vehicle;

public class Main {

  public static void main(String[] args) {
    System.out.println("----------UPCASTING----------");
    System.out.println("---LOAD CLASS---");
    Vehicle vehicle;
    System.out.println("---CREATE OBJECT OF CLASS---");
    vehicle = new Car();
    System.out.println("----------NOT UPCASTING----------");
    System.out.println("---LOAD CLASS---");
    Car car;
    System.out.println("---CREATE OBJECT OF CLASS---");
    car = new Car();
  }
}
