package com.iquestgroup.remotelearning.week15.w15p1;

import com.iquestgroup.remotelearning.week15.w15p1.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDao {

  private static final String GET_ALL_EVENTS_QUERY = "SELECT * FROM EVENT";
  private static final String ADD_EVENT_STATEMENT = " INSERT INTO EVENT (start_date_time, end_date_time, summary, location)"
      + " VALUES (?, ?, ?, ?)";
  private static final String DATABASE_EXCEPTION_MESSAGE = "SQLException was thrown!";
  private final Connection databaseConnection;

  public EventDao(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public List<Event> getAllEvents() {
    List<Event> allEvents = new ArrayList<>();
    try (Statement statement = databaseConnection.createStatement()) {
      ResultSet events = statement.executeQuery(GET_ALL_EVENTS_QUERY);
      while (events.next()) {
        String startDateTimeAsString = events.getString("start_date_time");
        ZonedDateTime startDateTime = ZonedDateTime.parse(startDateTimeAsString);
        String endDateTimeAsString = events.getString("end_date_time");
        ZonedDateTime endDateTime = ZonedDateTime.parse(endDateTimeAsString);
        String summary = events.getString("summary");
        String location = events.getString("location");
        allEvents.add(new Event(startDateTime, endDateTime, summary, location));
      }
      return allEvents;
    } catch (SQLException exception) {
      exception.printStackTrace();
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }

  public void addEvent(Event newEvent) {
    try (PreparedStatement addEvent = databaseConnection.prepareStatement(ADD_EVENT_STATEMENT)) {
      addEvent.setString(1, newEvent.getStartDateTime().toString());
      addEvent.setString(2, newEvent.getEndDateTime().toString());
      addEvent.setString(3, newEvent.getSummary());
      addEvent.setString(4, newEvent.getLocation());
      addEvent.executeUpdate();
    } catch (SQLException exception) {
      exception.printStackTrace();
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
