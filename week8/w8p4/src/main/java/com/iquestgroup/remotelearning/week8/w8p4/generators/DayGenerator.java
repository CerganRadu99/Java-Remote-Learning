package com.iquestgroup.remotelearning.week8.w8p4.generators;

import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import com.iquestgroup.remotelearning.week8.w8p4.models.Day;
import java.util.Random;

public class DayGenerator implements Generator<Day> {

  private static final int RANDOM_SEED = 39;
  private static final Random random = new Random(RANDOM_SEED);
  private static final int[] DAYS_OF_MONTH;
  private static final int[] MONTHS_OF_YEAR;

  static {
    DAYS_OF_MONTH = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    MONTHS_OF_YEAR = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
  }

  @Override
  public Day next() {
    int dayOfMonth = DAYS_OF_MONTH[random.nextInt(DAYS_OF_MONTH.length)];
    int month = MONTHS_OF_YEAR[random.nextInt(MONTHS_OF_YEAR.length)];
    return new Day(dayOfMonth, month);
  }
}
