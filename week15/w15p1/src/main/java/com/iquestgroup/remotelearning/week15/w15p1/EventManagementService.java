package com.iquestgroup.remotelearning.week15.w15p1;

import com.iquestgroup.remotelearning.week15.w15p1.exception.EventManagementException;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EventManagementService {

  private final EventDao eventDao;
  private final Scanner input = new Scanner(System.in);
  private static final String EXCEPTION_MESSAGE = "Wrong input format!";

  public EventManagementService(EventDao eventDao) {
    this.eventDao = eventDao;
  }

  public void addEvent() {
    System.out.println("Summary: ");
    String summary = input.nextLine();
    System.out.println("Start Date Time: ");
    ZonedDateTime startTime = getDate();
    System.out.println("End Date Time: ");
    ZonedDateTime endTime = getDate();
    System.out.println("Location: ");
    String location = input.nextLine();
    Event newEvent = new Event(startTime, endTime, summary, location);
    eventDao.addEvent(newEvent);
  }

  public void listNextWeekendEvents() {
    ZonedDateTime localTime = ZonedDateTime.now();
    int distanceToWeekend = localTime.getDayOfWeek().getValue() - DayOfWeek.FRIDAY.getValue();
    if(distanceToWeekend < 0){
      distanceToWeekend = -distanceToWeekend;
    }
    ZonedDateTime nextWeekend = localTime.withDayOfMonth(localTime.getDayOfMonth() + distanceToWeekend);
    printEventsInInterval(nextWeekend, nextWeekend.plusDays(2));
  }

  public void listEventsFromDate() {
    System.out.println("Date: ");
    ZonedDateTime date = getDate();
    System.out.println("Time Zone: ");
    ZoneId zoneId = getZoneId();
    ZonedDateTime dateWithZone = date.withZoneSameInstant(zoneId);
    printEventsInInterval(dateWithZone, dateWithZone);
  }

  public void listEventsFromInterval() {
    System.out.println("Start time: ");
    ZonedDateTime startTime = getDate();
    System.out.println("End time: ");
    ZonedDateTime endTime = getDate();
    printEventsInInterval(startTime, endTime);
  }

  private void printEventsInInterval(ZonedDateTime startTime, ZonedDateTime endTime){
    List<Event> allEvents = eventDao.getAllEvents();
    for(Event event : allEvents){
      if(startTime.isBefore(event.getStartDateTime()) && event.getEndDateTime().isBefore(endTime)){
        System.out.println(event);
      }
    }
  }

  private ZonedDateTime getDate(){
    try{
      ZonedDateTime date = ZonedDateTime.parse(input.nextLine());
      return date;
    } catch(DateTimeParseException exception){
      throw new EventManagementException(EXCEPTION_MESSAGE);
    }
  }

  private ZoneId getZoneId(){
    try{
      ZoneId zoneId = ZoneId.of(input.nextLine());
      return zoneId;
    } catch(DateTimeException exception){
      throw new EventManagementException(EXCEPTION_MESSAGE);
    }
  }
}
