package com.iquestgroup.remotelearning.week10.w10p3;

import com.iquestgroup.remotelearning.week10.w10p3.models.ThreadRelayRace;

public class Main {

  public static void main(String[] args) {
    Thread threadRelayRace = new Thread(new ThreadRelayRace());
    threadRelayRace.start();
  }
}
