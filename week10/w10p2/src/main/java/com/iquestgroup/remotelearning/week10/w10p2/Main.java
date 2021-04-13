package com.iquestgroup.remotelearning.week10.w10p2;

import com.iquestgroup.remotelearning.week10.w10p2.models.ThreadRace;

public class Main {

  public static void main(String[] args) {
    Thread threadRace = new Thread(new ThreadRace());
    threadRace.start();
  }
}
