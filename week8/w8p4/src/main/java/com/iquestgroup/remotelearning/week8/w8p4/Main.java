package com.iquestgroup.remotelearning.week8.w8p4;

import com.iquestgroup.remotelearning.week8.w8p1.filler.CollectionFiller;
import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import com.iquestgroup.remotelearning.week8.w8p4.generators.DayGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.generators.KeyGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.generators.ValueGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.models.Day;
import com.iquestgroup.remotelearning.week8.w8p4.models.Train;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static final int TRAIN_NUMBER = 9321;
  public static final String TRAIN_TYPE = "Rapid Transit";
  public static final int NO_WAGONS = 2;

  public static void main(String[] args) {
    Generator<Train> trainGenerator = new KeyGenerator();
    Generator<List<Day>> runningDaysGenerator = new ValueGenerator(new DayGenerator());
    HashMap<Train, List<Day>> trains = (HashMap<Train, List<Day>>) CollectionFiller.fillMap(trainGenerator, runningDaysGenerator, 10000);
    
    System.out.println("Size of the hashMap is: " + trains.size());
    Train trainToRetrieve = new Train(TRAIN_NUMBER, TRAIN_TYPE, NO_WAGONS);

    long start = System.nanoTime();
    List<Day> runningDays = trains.get(trainToRetrieve);
    long end = System.nanoTime();

    long totalTimeInNano = end - start;
    System.out.println("Performance: " + totalTimeInNano);
    System.out.println(runningDays);
  }
}
