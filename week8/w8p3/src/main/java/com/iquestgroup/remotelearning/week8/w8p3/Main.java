package com.iquestgroup.remotelearning.week8.w8p3;

import com.iquestgroup.remotelearning.week8.w8p1.filler.CollectionFiller;
import com.iquestgroup.remotelearning.week8.w8p1.models.CollectionType;
import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import com.iquestgroup.remotelearning.week8.w8p3.generator.TrainGenerator;
import com.iquestgroup.remotelearning.week8.w8p3.models.Train;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Generator<Train> trainGenerator = new TrainGenerator();
    Set<Train> trains = (HashSet<Train>) CollectionFiller.fillCollection(CollectionType.SET, trainGenerator, 12);
    for (Train train : trains) {
      System.out.println(train);
    }
  }
}
