package com.iquestgroup.remotelearning.week8.w8p3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.iquestgroup.remotelearning.week8.w8p3.filler.TrainSetFiller;
import com.iquestgroup.remotelearning.week8.w8p3.generator.TrainGeneratorImpl;
import com.iquestgroup.remotelearning.week8.w8p3.models.Train;
import com.iquestgroup.remotelearning.week8.w8p3.models.TrainGenerator;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class TrainSetTest {

  public static final int VALID_RANDOM_SEED;
  public static final int NUMBER_OF_TRAINS_GENERATED;
  public static final Set<Train> NO_DUPLICATED_ELEMENTS_SET;

  static {
    VALID_RANDOM_SEED = 1;
    NUMBER_OF_TRAINS_GENERATED = 12;
    NO_DUPLICATED_ELEMENTS_SET = new HashSet<>();
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1201, "Commuter", 2));
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1117, "Short-Distance", 3));
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1115, "Regional", 5));
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1205, "Commuter", 5));
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1119, "Rapid Transit", 5));
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1203, "Rapid Transit", 4));
    NO_DUPLICATED_ELEMENTS_SET.add(new Train(1111, "Commuter", 5));
  }

  private HashSet<Train> trains;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testNoDuplicatedElements() {
    int expectedSize = NO_DUPLICATED_ELEMENTS_SET.size();
    int actualSize = trains.size();
    assertEquals(expectedSize, actualSize);
    for (Train currentTrain : NO_DUPLICATED_ELEMENTS_SET) {
      boolean actualResult = trains.contains(currentTrain);
      assertTrue(actualResult);
    }
  }

  private void initData() {
    TrainGenerator trainGenerator = new TrainGeneratorImpl();
    TrainSetFiller trainSetFiller = new TrainSetFiller();
    trains = (HashSet<Train>) trainSetFiller.fillTrainSet(trainGenerator, NUMBER_OF_TRAINS_GENERATED);
  }
}
