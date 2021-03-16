package com.iquestgroup.remotelearning.week6.w6p1v2.models;

public enum DayOfWeek {
  MONDAY(1),
  TUESDAY(2),
  WEDNESDAY(3),
  THURSDAY(4),
  FRIDAY(5),
  SATURDAY(6),
  SUNDAY(0);

  private final int id;

  DayOfWeek(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}