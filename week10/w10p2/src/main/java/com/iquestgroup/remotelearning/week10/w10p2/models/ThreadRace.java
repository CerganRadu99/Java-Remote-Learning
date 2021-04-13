package com.iquestgroup.remotelearning.week10.w10p2.models;

import java.util.ArrayList;
import java.util.List;

public class ThreadRace implements Runnable {

  private static final int NUMBER_OF_COMPETITORS = 10;
  private final ThreadRaceContext context = new ThreadRaceContext();

  @Override
  public void run() {
    List<Thread> competitors = new ArrayList<>();
    for (int i = 0; i < NUMBER_OF_COMPETITORS; i++) {
      Thread currentCompetitor = new Thread(new ThreadRaceCompetitor(i, context));
      competitors.add(currentCompetitor);
      currentCompetitor.start();
    }
    for (int i = 0; i < NUMBER_OF_COMPETITORS; i++) {
      try {
        competitors.get(i).join();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
    context.listFinalRankings();
  }
}
