package com.iquestgroup.remotelearning.week14.w14p3.generator;

import java.util.Random;

public class ScoreGenerator {

  private static final String[] POSSIBLE_SCORES = new String[]{"100", "200", "300"};
  private final Random random = new Random();

  public String getScore() {
    return POSSIBLE_SCORES[random.nextInt(POSSIBLE_SCORES.length)];
  }
}
