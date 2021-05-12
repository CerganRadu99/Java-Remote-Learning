package com.iquestgroup.remotelearning.week15.w15p1;

import java.time.LocalDate;
import java.util.List;

public class EventManagementService {

  private final EventDao eventDao;

  public EventManagementService(EventDao eventDao) {
    this.eventDao = eventDao;
  }

  public void addEvent(Event newEvent) {
    eventDao.addEvent(newEvent);
  }

  public void listNextWeekendEvents() {
    List<Event> allEvents = getAllEvents();
    LocalDate currentDate = LocalDate.now();
    String currentDayOfWeek = currentDate.getDayOfWeek().toString();
    String currentDateAsString = currentDate.toString();
    for (Event event : allEvents) {
      String startDateTime = event.getStartDateTime();
      String eventDate = startDateTime.substring(0, startDateTime.lastIndexOf(" "));
      if (checkIfEventTakesPlaceNextWeekend(eventDate, currentDateAsString, currentDayOfWeek)) {
        System.out.println("Summary: " + event.getSummary());
        System.out.println("Start Date Time: " + event.getStartDateTime());
        System.out.println("End Date Time: " + event.getEndDateTime());
        System.out.println("Location: " + event.getLocation());
        System.out.println();
      }
    }
  }

  private boolean checkIfEventTakesPlaceNextWeekend(String eventDate, String actualDate, String actualDayOfWeek) {
    String currentYear = getYear(actualDate);
    String currentMonth = getMonth(actualDate);
    String currentDay = getDay(actualDate);

    String eventYear = getYear(eventDate);
    String eventMonth = getMonth(eventDate);
    String eventDay = getDay(eventDate);

    if (currentYear.equals(eventYear) && currentMonth.equals(eventMonth)) {
      int numberOfDaysUntilWeekend = getNumberOfDaysUntilWeekend(actualDayOfWeek);
      int eventDayAsInt = Integer.parseInt(eventDay);
      int firstWeekendDayAsInt = Integer.parseInt(currentDay) + numberOfDaysUntilWeekend;
      int secondWeekendDayAsInt = Integer.parseInt(currentDay) + numberOfDaysUntilWeekend + 1;
      return eventDayAsInt == firstWeekendDayAsInt || eventDayAsInt == secondWeekendDayAsInt ? true : false;
    }
    return false;
  }

  private String getYear(String actualDate) {
    return actualDate.substring(0, actualDate.indexOf("-"));
  }

  private String getMonth(String actualDate) {
    return actualDate.substring(actualDate.indexOf("-") + 1, actualDate.lastIndexOf("-"));
  }

  private String getDay(String actualDate) {
    return actualDate.substring(actualDate.lastIndexOf("-") + 1);
  }

  private int getNumberOfDaysUntilWeekend(String dayOfWeek) {
    switch (dayOfWeek) {
      case ("MONDAY"):
        return 5;
      case ("TUESDAY"):
        return 4;
      case ("WEDNESDAY"):
        return 3;
      case ("THURSDAY"):
        return 2;
      case ("FRIDAY"):
        return 1;
      default:
        return -1;
    }
  }

  /*public void listEventsFromDate(LocalDate date, ZoneId timeZone) {
    List<Event> allEvents = getAllEvents();

  }

  public void listEventsFromInterval() {
    List<Event> allEvents = getAllEvents();

  }*/

  public List<Event> getAllEvents() {
    return eventDao.getAllEvents();
  }
}
