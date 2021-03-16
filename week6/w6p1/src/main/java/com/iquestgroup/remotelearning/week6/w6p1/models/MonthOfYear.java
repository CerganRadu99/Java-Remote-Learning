package com.iquestgroup.remotelearning.week6.w6p1.models;

public enum MonthOfYear {
  JANUARY(
      "It’s the first month of the year. "
          + "January has 31 days, "
          + "In the Northern Hemisphere marks the start of winter, "
          + "while in the Southern the summertime is just beginning."),
  FEBRUARY(
      "It’s the shortest month of the year, "
          + "and it’s very special! "
          + "February has 28 days usually, but every 4 years, "
          + "it has got one more day to end up with 29. "
          + "This extra day is called leap day."),
  MARCH(
      "The spring month! At least in the Northern Hemisphere. "
          + "In the Southern Hemisphere, March marks the start of fall. "
          + "It has 31 days."),
  APRIL(
      "April has 30 days. In some places in the Northern Hemisphere, "
          + "it comes with lots of rain and windy weather."),
  MAY("It’s the fifth month of the year, and it has 31 days. "
      + "May marks the beginning of Winter on the Southern Hemisphere, "
      + "and it marks the end of Spring, which lasts until June, in the Northern Hemisphere."),
  JUNE(
      "June has 30 days, and it’s just in the middle of the year! "
          + "For the people living in the Southern Hemisphere, it comes with cold temperatures, "
          + "but in the Northern region, it represents the start of summer and sunny days."),
  JULY(
      "With 31 days, July is midsummer for the Northern region, "
          + "and frequently associated with the start of vacations!"),
  AUGUST(
      "A cold month for the Southern region that marks the end of their Winter. "
          + "August has 31 days. In the Northern Hemisphere, "
          + "it’s time to go to the beach and enjoy the water."),
  SEPTEMBER(
      "It’s the ninth month of the year and the start of Fall in the Northern region. "
          + "It also represents in many places the start of a new school year. "
          + "September has 30 days."),
  OCTOBER(
      "Leaves start to fall in some places, while days get a bit warmer in others! "
          + "October is the tenth month of the year, and it has 31 days."),
  NOVEMBER(
      "In November, the Northern Hemisphere gets colder temperatures each day, "
          + "while in the other half of the world the temperature keeps rising. "
          + "It has 30 days and it’s the 11th month of the year."),
  DECEMBER(
      "December is the last month of the year. It has 31 days, "
          + "and it marks the beginning of summer for the Southern Hemisphere, "
          + "while in the Northern one is the start of wintertime.");

  private final String description;

  MonthOfYear(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
