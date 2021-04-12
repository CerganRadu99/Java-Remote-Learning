package com.iquestgroup.remotelearning.week8.w8p4.generators;

import com.iquestgroup.remotelearning.week8.w8p4.models.Day;
import com.iquestgroup.remotelearning.week8.w8p4.models.DayGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.models.DayListGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValueGenerator implements DayListGenerator {

  private static final int MAX_RUNNING_DAYS = 10;
  private final Random random;
  private final DayGenerator dayGenerator;

  public ValueGenerator(DayGenerator dayGenerator, int randomSeed) {
    this.dayGenerator = dayGenerator;
    random = new Random(randomSeed);
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
