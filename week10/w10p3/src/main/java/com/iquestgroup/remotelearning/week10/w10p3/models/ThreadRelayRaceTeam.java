package com.iquestgroup.remotelearning.week10.w10p3.models;

import java.util.List;

public class ThreadRelayRaceTeam implements Runnable {

  private final ThreadRaceContext context;
  private final String name;
  private final List<Thread> competitors;

  public ThreadRelayRaceTeam(String name, ThreadRaceContext context, List<Thread> competitors) {
    this.name = name;
    this.context = context;
    this.competitors = competitors;
  }

  @Override
  public void run() {
    for (Thread competitor : competitors) {
      competitor.start();
      try {
        competitor.join();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
    context.registerTeam(name);
  }
}
