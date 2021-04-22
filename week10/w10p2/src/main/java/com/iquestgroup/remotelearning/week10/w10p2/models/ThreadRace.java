package com.iquestgroup.remotelearning.week10.w10p2.models;

import java.util.ArrayList;
import java.util.List;

public class ThreadRace implements Runnable {

  private static final int NUMBER_OF_COMPETITORS = 10;
  private final ThreadRaceContext context = new ThreadRaceContext();

  @Override
  public void run() {
    List<Thread> competitors = new ArrayList<>();
    for (int idOfCompetitor = 0; idOfCompetitor < NUMBER_OF_COMPETITORS; idOfCompetitor++) {
      Thread currentCompetitor = new Thread(new ThreadRaceCompetitor(idOfCompetitor, context));
      competitors.add(currentCompetitor);
      currentCompetitor.start();
    }
    registerForResults(competitors);
    context.listFinalRankings();
  }

  private void registerForResults(List<Thread> competitors){
    for (int idOfCompetitor = 0; idOfCompetitor < NUMBER_OF_COMPETITORS; idOfCompetitor++) {
      try {
        competitors.get(idOfCompetitor).join();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }
}
