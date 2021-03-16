package com.iquestgroup.remotelearning.week6.w6p1;

import com.iquestgroup.remotelearning.week6.w6p1.models.DateViewerImpl;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    Date date = new Date();
    DateViewerImpl dateViewerImpl = new DateViewerImpl(date);
    dateViewerImpl.displayDate();
    System.out.println(dateViewerImpl.getDayOfWeek().getDescription());
    System.out.println(dateViewerImpl.getMonthOfYear().getDescription());
  }
}
