package com.iquestgroup.remotelearning.week8.w8p4;

import com.iquestgroup.remotelearning.week8.w8p4.filler.TrainScheduleFiller;
import com.iquestgroup.remotelearning.week8.w8p4.generators.DayGeneratorImpl;
import com.iquestgroup.remotelearning.week8.w8p4.generators.KeyGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.generators.ValueGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.models.Day;
import com.iquestgroup.remotelearning.week8.w8p4.models.DayListGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.models.Train;
import com.iquestgroup.remotelearning.week8.w8p4.models.TrainGenerator;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static final int KEY_GENERATOR_RANDOM_SEED = 1;
  public static final int DAY_GENERATOR_RANDOM_SEED = 39;
  public static final int VALUE_GENERATOR_RANDOM_SEED = 30;
  public static final int TRAIN_NUMBER = 9321;
  public static final String TRAIN_TYPE = "Rapid Transit";
  public static final int NO_WAGONS = 2;

  public static void main(String[] args) {
    TrainGenerator trainGenerator = new KeyGenerator(KEY_GENERATOR_RANDOM_SEED);
    DayListGenerator runningDaysGenerator = new ValueGenerator(new DayGeneratorImpl(DAY_GENERATOR_RANDOM_SEED), VALUE_GENERATOR_RANDOM_SEED);
    TrainScheduleFiller trainScheduleFiller = new TrainScheduleFiller();
    HashMap<Train, List<Day>> trainsSchedule = (HashMap<Train, List<Day>>) trainScheduleFiller
        .fillTrainsSchedule(trainGenerator, runningDaysGenerator, 10000);

    System.out.println("Size of the hashMap is: " + trainsSchedule.size());
    Train trainToRetrieve = new Train(TRAIN_NUMBER, TRAIN_TYPE, NO_WAGONS);

    long start = System.nanoTime();
    List<Day> runningDays = trainsSchedule.get(trainToRetrieve);
    long end = System.nanoTime();

    long totalTimeInNano = end - start;
    System.out.println("Performance: " + totalTimeInNano);
    System.out.println(runningDays);
  }
}
