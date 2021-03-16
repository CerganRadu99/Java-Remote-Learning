package com.iquestgroup.remotelearning.week6.w6p1.models;

import static com.iquestgroup.remotelearning.week6.w6p1.models.DayOfWeek.*;
import static com.iquestgroup.remotelearning.week6.w6p1.models.MonthOfYear.*;

import java.util.Date;

public class DateViewerImpl implements DateViewer {

  private static final String STRING_DELIMITER = " ";
  private static final int TO_OBTAIN_YEAR = 1900;
  private DayOfWeek dayOfWeek;
  private MonthOfYear monthOfYear;

  private final Date date;

  public DateViewerImpl(Date date) {
    this.date = date;
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public MonthOfYear getMonthOfYear() {
    return monthOfYear;
  }

  @Override
  public void displayDate() {
    setDayOfWeek();
    setMonthOfYear();
    int year = date.getYear() + TO_OBTAIN_YEAR;
    System.out.println(
        dayOfWeek.name() + STRING_DELIMITER + monthOfYear.name() + STRING_DELIMITER + year);
  }

  private void setDayOfWeek() {
    switch (date.getDay()) {
      case 0:
        dayOfWeek = SUNDAY;
        break;
      case 1:
        dayOfWeek = MONDAY;
        break;
      case 2:
        dayOfWeek = TUESDAY;
        break;
      case 3:
        dayOfWeek = WEDNESDAY;
        break;
      case 4:
        dayOfWeek = THURSDAY;
        break;
      case 5:
        dayOfWeek = FRIDAY;
        break;
      case 6:
        dayOfWeek = SATURDAY;
        break;
    }
  }

  private void setMonthOfYear() {
    switch (date.getMonth()) {
      case 0:
        monthOfYear = JANUARY;
        break;
      case 1:
        monthOfYear = FEBRUARY;
        break;
      case 2:
        monthOfYear = MARCH;
        break;
      case 3:
        monthOfYear = APRIL;
        break;
      case 4:
        monthOfYear = MAY;
        break;
      case 5:
        monthOfYear = JUNE;
        break;
      case 6:
        monthOfYear = JULY;
        break;
      case 7:
        monthOfYear = AUGUST;
        break;
      case 8:
        monthOfYear = SEPTEMBER;
        break;
      case 9:
        monthOfYear = OCTOBER;
        break;
      case 10:
        monthOfYear = NOVEMBER;
        break;
      case 11:
        monthOfYear = DECEMBER;
        break;
    }
  }
}
