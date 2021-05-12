package com.iquestgroup.remotelearning.week15.w15p1;

public class Event {

  private final int id;
  private final String startDateTime;
  private final String endDateTime;
  private final String summary;
  private final String location;

  public Event(int id, String startDateTime, String endDateTime, String summary, String location) {
    this.id = id;
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
    this.summary = summary;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public String getStartDateTime() {
    return startDateTime;
  }

  public String getEndDateTime() {
    return endDateTime;
  }

  public String getSummary() {
    return summary;
  }

  public String getLocation() {
    return location;
  }
}
