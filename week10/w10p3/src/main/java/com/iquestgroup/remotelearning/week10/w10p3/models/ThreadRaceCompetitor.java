package com.iquestgroup.remotelearning.week10.w10p3.models;

public class ThreadRaceCompetitor implements Runnable {

  private final int id;
  private final String teamName;
  private final ThreadRaceContext context;

  public ThreadRaceCompetitor(int id, String teamName, ThreadRaceContext context) {
    this.id = id;
    this.teamName = teamName;
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
    context.competitorFinished(id, teamName);
  }
}
