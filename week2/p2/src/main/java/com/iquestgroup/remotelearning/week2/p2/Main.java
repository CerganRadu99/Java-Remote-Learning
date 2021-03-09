package com.iquestgroup.remotelearning.week2.p2;

import com.iquestgroup.remotelearning.week2.p2.models.Tank;
import com.iquestgroup.remotelearning.week2.p2.models.TankImpl;
import com.iquestgroup.remotelearning.week2.p2.models.TankObject;

public class Main {

  public static void main(String[] args) {
    Tank<TankObject> tank = new TankImpl(10, 1);
    //Proper cleanup
    tank.emptyTank();
    //Drop the reference, forget to clean up
    new TankImpl(10, 2);
    //Force garbage collection & finalization
    System.gc();
  }
}
