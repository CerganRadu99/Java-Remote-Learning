package com.iquestgroup.remotelearning.week8.w8p4.filler;

import com.iquestgroup.remotelearning.week8.w8p4.models.Day;
import com.iquestgroup.remotelearning.week8.w8p4.models.DayListGenerator;
import com.iquestgroup.remotelearning.week8.w8p4.models.Train;
import com.iquestgroup.remotelearning.week8.w8p4.models.TrainGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainScheduleFiller {

  public Map<Train, List<Day>> fillTrainsSchedule(TrainGenerator trainGenerator, DayListGenerator dayListGenerator, int length) {
    Map<Train, List<Day>> trainsSchedule = new HashMap<>();
    for (int index = 0; index < length; index++) {
      trainsSchedule.put(trainGenerator.next(), dayListGenerator.next());
    }
    return trainsSchedule;
  }
}
