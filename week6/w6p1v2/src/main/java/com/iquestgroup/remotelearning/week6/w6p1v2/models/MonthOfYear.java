package com.iquestgroup.remotelearning.week6.w6p1v2.models;

public enum MonthOfYear {
  JANUARY(0),
  FEBRUARY(1),
  MARCH(2),
  APRIL(3),
  MAY(4),
  JUNE(5),
  JULY(6),
  AUGUST(7),
  SEPTEMBER(8),
  OCTOBER(9),
  NOVEMBER(10),
  DECEMBER(11);

  private final int id;

  MonthOfYear(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
