package com.iquestgroup.remotelearning.week10.w10p3.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadRaceContext {

  private final Map<String, Integer> competitorsRanking = new LinkedHashMap<>();
  private final Map<String, Integer> teamsRanking = new LinkedHashMap<>();
  private int competitorPosition = 0;
  private int teamPosition = 0;

  public synchronized void registerCompetitor(int id, String teamName) {
    competitorsRanking.put(teamName + " " + id, ++competitorPosition);
  }

  public synchronized void registerTeam(String teamName) {
    teamsRanking.put(teamName, ++teamPosition);
  }

  public void listCompetitorsPositions() {
    for (Map.Entry<String, Integer> currentCompetitorRanking : competitorsRanking.entrySet()) {
      System.out.println("Competitor " + currentCompetitorRanking.getKey() + " finished on position: " + currentCompetitorRanking.getValue());
    }
  }

  public void listTeamsPositions() {
    for (Map.Entry<String, Integer> currentTeamRanking : teamsRanking.entrySet()) {
      System.out.println("Team " + currentTeamRanking.getKey() + " finished on position: " + currentTeamRanking.getValue());
    }
  }

}
