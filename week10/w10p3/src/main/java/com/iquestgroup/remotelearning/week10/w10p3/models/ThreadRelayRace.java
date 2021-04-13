package com.iquestgroup.remotelearning.week10.w10p3.models;

import com.iquestgroup.remotelearning.week10.w10p3.generator.TeamGenerator;
import com.iquestgroup.remotelearning.week10.w10p3.generator.TeamGeneratorImpl;
import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRace implements Runnable {

  private static final int NUMBER_OF_TEAMS = 10;
  private static final int NUMBER_OF_COMPETITORS = 4;
  private final ThreadRaceContext context = new ThreadRaceContext();

  @Override
  public void run() {
    List<Thread> teams = new ArrayList<>();
    TeamGenerator teamGenerator = new TeamGeneratorImpl();
    for (int i = 0; i < NUMBER_OF_TEAMS; i++) {
      List<Thread> competitors = new ArrayList<>();
      String currentTeamName = teamGenerator.next();
      for (int j = 0; j < NUMBER_OF_COMPETITORS; j++) {
        competitors.add(new Thread(new ThreadRaceCompetitor(j, currentTeamName, context)));
      }
      Thread currentTeam = new Thread(new ThreadRelayRaceTeam(currentTeamName, context, competitors));
      teams.add(currentTeam);
      currentTeam.start();
    }
    for (int i = 0; i < NUMBER_OF_TEAMS; i++) {
      try {
        teams.get(i).join();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
    context.listTeamsPositions();
    context.listCompetitorsPositions();
  }
}
