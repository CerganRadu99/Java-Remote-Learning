package com.iquestgroup.remotelearning.week10.w10p2.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadRaceContext {

  private final Map<Integer, Integer> ranking = new LinkedHashMap<>();
  private int competitorPosition = 0;

  public synchronized void registerCompetitor(int id) {
    ranking.put(id, ++competitorPosition);
  }

  public void listFinalRankings() {
    for (Map.Entry<Integer, Integer> currentEntry : ranking.entrySet()) {
      System.out.println("Competitor with id " + currentEntry.getKey() + " finished on position: " + currentEntry.getValue());
    }
  }
}
