package com.iquestgroup.remotelearning.week8.w8p4.generators;

import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import com.iquestgroup.remotelearning.week8.w8p4.models.Day;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValueGenerator implements Generator<List<Day>> {

  private static final int RANDOM_SEED = 30;
  private static final int MAX_RUNNING_DAYS = 10;
  private static final Random random = new Random(RANDOM_SEED);
  private final Generator<Day> dayGenerator;

  public ValueGenerator(Generator<Day> dayGenerator) {
    this.dayGenerator = dayGenerator;
  }

  @Override
  public List<Day> next() {
    int noRunningDays = random.nextInt(MAX_RUNNING_DAYS) + 1;
    List<Day> runningDays = new ArrayList<>();
    while (noRunningDays != 0) {
      Day currentDayGenerated = dayGenerator.next();
      while (runningDays.contains(currentDayGenerated)) {
        currentDayGenerated = dayGenerator.next();
      }
      runningDays.add(currentDayGenerated);
      noRunningDays--;
    }
    return runningDays;
  }
}
