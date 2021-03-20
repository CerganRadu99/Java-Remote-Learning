package com.iquestgroup.remotelearning.week6.w6p1v2.models;

import java.util.Date;

public class DateViewerImpl implements DateViewer {

  private static final String STRING_DELIMITER = " ";
  private static final int TO_OBTAIN_YEAR = 1900;
  private DayOfWeek dayOfWeek;
  private MonthOfYear monthOfYear;


  public DateViewerImpl() {
  }

  @Override
  public void displayDate(Date currentDate) {
    computeEnumDate(currentDate);
    int year = currentDate.getYear() + TO_OBTAIN_YEAR;
    System.out.println(dayOfWeek + STRING_DELIMITER + monthOfYear + STRING_DELIMITER + year);
  }

  private void computeEnumDate(Date currentDate) {
    for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
      if (currentDate.getDay() == dayOfWeek.getId()) {
        this.dayOfWeek = dayOfWeek;
      }
    }
    for (MonthOfYear monthOfYear : MonthOfYear.values()) {
      if (currentDate.getMonth() == monthOfYear.getId()) {
        this.monthOfYear = monthOfYear;
      }
    }
  }
}
