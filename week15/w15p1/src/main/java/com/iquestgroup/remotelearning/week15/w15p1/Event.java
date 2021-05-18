package com.iquestgroup.remotelearning.week15.w15p1;

import java.time.ZonedDateTime;

public class Event {

  private final ZonedDateTime startDateTime;
  private final ZonedDateTime endDateTime;
  private final String summary;
  private final String location;

  public Event(ZonedDateTime startDateTime, ZonedDateTime endDateTime, String summary, String location) {
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
    this.summary = summary;
    this.location = location;
  }

  public ZonedDateTime getStartDateTime() {
    return startDateTime;
  }

  public ZonedDateTime getEndDateTime() {
    return endDateTime;
  }

  public String getSummary() {
    return summary;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public String toString() {
    return "Event{" +
        "startDateTime=" + startDateTime +
        ", endDateTime=" + endDateTime +
        ", summary='" + summary + '\'' +
        ", location='" + location + '\'' +
        '}';
  }
}
