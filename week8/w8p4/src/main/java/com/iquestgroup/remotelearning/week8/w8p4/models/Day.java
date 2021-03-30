package com.iquestgroup.remotelearning.week8.w8p4.models;

import java.util.Objects;

public class Day {

  private final int dayOfMonth;
  private final int month;

  public Day(int dayOfMonth, int month) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException();
    } else {
      this.dayOfMonth = dayOfMonth;
      this.month = month;
    }

    if (dayOfMonth < 1 || dayOfMonth > 31) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String toString() {
    return "Day{" +
        "dayOfMonth=" + dayOfMonth +
        ", month=" + month +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Day day = (Day) o;
    return dayOfMonth == day.dayOfMonth && month == day.month;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dayOfMonth, month);
  }
}
