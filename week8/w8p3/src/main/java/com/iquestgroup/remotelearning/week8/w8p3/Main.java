package com.iquestgroup.remotelearning.week8.w8p3;

import com.iquestgroup.remotelearning.week8.w8p3.filler.TrainSetFiller;
import com.iquestgroup.remotelearning.week8.w8p3.generator.TrainGeneratorImpl;
import com.iquestgroup.remotelearning.week8.w8p3.models.Train;
import com.iquestgroup.remotelearning.week8.w8p3.models.TrainGenerator;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) {
    TrainGenerator trainGenerator = new TrainGeneratorImpl();
    TrainSetFiller trainSetFiller = new TrainSetFiller();
    HashSet<Train> trains = (HashSet<Train>) trainSetFiller.fillTrainSet(trainGenerator, 12);
    for (Train train : trains) {
      System.out.println(train);
    }
  }
}
