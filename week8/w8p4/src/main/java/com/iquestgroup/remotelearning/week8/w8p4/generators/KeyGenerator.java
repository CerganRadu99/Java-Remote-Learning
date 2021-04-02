package com.iquestgroup.remotelearning.week8.w8p4.generators;

import com.iquestgroup.remotelearning.week8.w8p4.models.Train;
import com.iquestgroup.remotelearning.week8.w8p4.models.TrainGenerator;
import java.util.Random;

public class KeyGenerator implements TrainGenerator {

  private static final int RANDOM_SEED = 1;
  private static final Random random = new Random(RANDOM_SEED);
  private static final String[] TRAIN_TYPES;
  private static final int[] NUMBER_OF_WAGONS;

  static {
    TRAIN_TYPES = new String[]{"Inter-City", "Regional", "Rapid Transit", "Commuter", "Short-Distance"};
    NUMBER_OF_WAGONS = new int[]{3, 2, 4, 5};
  }

  private int trainNumber = 0;

  @Override
  public Train next() {
    String trainType = TRAIN_TYPES[random.nextInt(TRAIN_TYPES.length)];
    int noOfWagons = NUMBER_OF_WAGONS[random.nextInt(NUMBER_OF_WAGONS.length)];
    return new Train(++trainNumber, trainType, noOfWagons);
  }
}