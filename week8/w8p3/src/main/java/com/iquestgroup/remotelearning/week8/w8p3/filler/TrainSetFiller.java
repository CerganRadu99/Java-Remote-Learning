package com.iquestgroup.remotelearning.week8.w8p3.filler;

import com.iquestgroup.remotelearning.week8.w8p3.models.Train;
import com.iquestgroup.remotelearning.week8.w8p3.models.TrainGenerator;
import java.util.HashSet;
import java.util.Set;

public class TrainSetFiller {

  public Set<Train> fillTrainSet(TrainGenerator trainGenerator, int length) {
    Set<Train> trains = new HashSet<>();
    for (int index = 0; index < length; index++) {
      trains.add(trainGenerator.next());
    }
    return trains;
  }
}
