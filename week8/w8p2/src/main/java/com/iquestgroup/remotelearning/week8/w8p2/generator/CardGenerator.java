package com.iquestgroup.remotelearning.week8.w8p2.generator;

import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import com.iquestgroup.remotelearning.week8.w8p2.models.Card;
import com.iquestgroup.remotelearning.week8.w8p2.models.Number;
import com.iquestgroup.remotelearning.week8.w8p2.models.Suite;

public class CardGenerator implements Generator<Card> {

  public static final Number[] NUMBERS;
  public static final Suite[] SUITES;

  static {
    NUMBERS = Number.values();
    SUITES = Suite.values();
  }

  private int indexNumbers = 0;
  private int indexSuites = 0;

  @Override
  public Card next() {
    if (indexSuites == SUITES.length) {
      indexSuites = 0;
      indexNumbers++;
    }
    return new Card(NUMBERS[indexNumbers], SUITES[indexSuites++]);
  }
}
