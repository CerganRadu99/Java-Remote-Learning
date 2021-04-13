package com.iquestgroup.remotelearning.week10.w10p3.generator;

public class TeamGeneratorImpl implements TeamGenerator {

  private static final String[] TEAM_NAMES;

  static {
    TEAM_NAMES = new String[]{"Amigos", "Bannermen", "Best of the Best", "Bosses", "Maniacs", "Rebels", "Warriors", "Vikings", "United", "Titans"};
  }

  private int index = 0;

  @Override
  public String next() {
    return TEAM_NAMES[index++];
  }
}
