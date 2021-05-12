package com.iquestgroup.remotelearning.week14.w14p3;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

  public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock();
    new Thread(new FootballPlayer(reentrantLock, 1)).start();
    new Thread(new FootballPlayer(reentrantLock, 2)).start();
  }
}
