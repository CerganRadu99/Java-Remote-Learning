package com.iquestgroup.remotelearning.week10.w10p2.models;

public class ThreadRaceCompetitor implements Runnable {

  private static final int TIME_TO_SLEEP = 1000;
  private final int id;
  private final ThreadRaceContext context;

  public ThreadRaceCompetitor(int id, ThreadRaceContext context) {
    this.id = id;
    this.context = context;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(TIME_TO_SLEEP);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
      Thread.currentThread().interrupt();
    }
    context.registerCompetitor(id);
  }
}
