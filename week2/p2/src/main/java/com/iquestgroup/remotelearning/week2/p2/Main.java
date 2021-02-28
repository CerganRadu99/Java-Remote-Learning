package com.iquestgroup.remotelearning.week2.p2;

public class Main {

  public static void main(String[] args) {
    Tank<TankObject> tank = new Tank<TankObject>(10);
    System.out.println(tank.size());
    //Proper cleanup
    tank.emptyTank();
    //Drop the reference, forget to clean up
    new Tank<TankObject>(10);
    //Force garbage collection & finalization
    System.gc();
  }
}
