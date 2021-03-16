package com.iquestgroup.remotelearning.week6.w6p1.models;

public enum DayOfWeek {
  MONDAY("It comes from the Latin dies lunae which means “Moon’s Day”."),
  TUESDAY("It means “Tiw’s Day”, name based on Týr, a god from Norse mythology."),
  WEDNESDAY("Name is taken from the Old English Wōdnesdæg, which means the day of Odin."),
  THURSDAY("This day’s name comes from the name of the Norse god Thor, "
      + "meaning “Thor’s day”."),
  FRIDAY("Meaning “day of Frigg”, comes from the name of the old Norse goddess Frigg."),
  SATURDAY("Named after the planet Saturn, this day’s name means “day of Saturn”."),
  SUNDAY("The “day of the Sun”, named after our well-known star, the Sun.");

  private final String description;

  DayOfWeek(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
