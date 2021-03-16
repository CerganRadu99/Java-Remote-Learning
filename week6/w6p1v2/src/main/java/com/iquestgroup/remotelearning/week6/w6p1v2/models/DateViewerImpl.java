package com.iquestgroup.remotelearning.week6.w6p1v2.models;

import java.util.Date;

public class DateViewerImpl implements DateViewer {

  private static final String STRING_DELIMITER = " ";
  private static final int TO_OBTAIN_YEAR = 1900;
  private final Date date;
  private DayOfWeek dayOfWeek;
  private MonthOfYear monthOfYear;

  public DateViewerImpl(Date date) {
    this.date = date;
    setDayOfWeek();
    setMonthOfYear();
  }

  @Override
  public void displayDate() {
    int year = date.getYear() + TO_OBTAIN_YEAR;
    System.out.println(dayOfWeek + STRING_DELIMITER + monthOfYear + STRING_DELIMITER + year);
  }

  private void setDayOfWeek() {
    for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
      if (date.getDay() == dayOfWeek.getId()) {
        this.dayOfWeek = dayOfWeek;
      }
    }
  }

  private void setMonthOfYear() {
    for (MonthOfYear monthOfYear : MonthOfYear.values()) {
      if (date.getMonth() == monthOfYear.getId()) {
        this.monthOfYear = monthOfYear;
      }
    }
  }
}
