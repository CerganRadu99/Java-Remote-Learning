package com.iquestgroup.remotelearning.week10.w10p2.models;

public class ThreadRaceCompetitor implements Runnable {

  private final int id;
  private final ThreadRaceContext context;

  public ThreadRaceCompetitor(int id, ThreadRaceContext context) {
    this.id = id;
    this.context = context;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
      Thread.currentThread().interrupt();
    }
    context.competitorFinished(id);
  }
}
