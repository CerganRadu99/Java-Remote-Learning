package com.iquestgroup.remotelearning.week8.w8p3.generator;

import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import com.iquestgroup.remotelearning.week8.w8p3.models.Train;
import java.util.Random;

public class TrainGenerator implements Generator<Train> {

  private static final int RANDOM_SEED = 1;
  private static final Random random = new Random(RANDOM_SEED);
  private static final int[] TRAIN_NUMBERS;
  private static final String[] TRAIN_TYPES;
  private static final int[] NUMBER_OF_WAGONS;

  static {
    TRAIN_NUMBERS = new int[]{1111, 1113, 1115, 1117, 1119, 1201, 1203, 1205};
    TRAIN_TYPES = new String[]{"Inter-City", "Regional", "Rapid Transit", "Commuter", "Short-Distance"};
    NUMBER_OF_WAGONS = new int[]{3, 2, 4, 5};
  }

  public static int getRandomSeed() {
    return RANDOM_SEED;
  }

  @Override
  public Train next() {
    int trainNumber = TRAIN_NUMBERS[random.nextInt(TRAIN_NUMBERS.length)];
    String trainType = TRAIN_TYPES[random.nextInt(TRAIN_TYPES.length)];
    int noOfWagons = NUMBER_OF_WAGONS[random.nextInt(NUMBER_OF_WAGONS.length)];
    return new Train(trainNumber, trainType, noOfWagons);
  }
}
