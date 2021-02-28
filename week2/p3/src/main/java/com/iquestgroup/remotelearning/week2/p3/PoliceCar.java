package com.iquestgroup.remotelearning.week2.p3;

public class PoliceCar extends Car{
  private Beacon beacon = getBeacon();
  private static String staticField;

  PoliceCar(){
    super();
    System.out.println("PoliceCar()");
    int localVariable = getLocalVariable();
  }

  static{
    staticField = getStaticField();
  }

  private Beacon getBeacon(){
    System.out.println("Field of PoliceCar - initialized");
    return new Beacon();
  }

  private int getLocalVariable(){
    System.out.println("local variable of PoliceCar - initialized");
    return 90;
  }

  private static String getStaticField(){
    System.out.println("static block of PoliceCar - initialized");
    return "static field";
  }




}
