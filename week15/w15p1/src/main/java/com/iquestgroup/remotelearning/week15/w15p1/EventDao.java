package com.iquestgroup.remotelearning.week15.w15p1;

import com.iquestgroup.remotelearning.week15.w15p1.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDao {

  private static final String GET_ALL_EVENTS_QUERY = "SELECT * FROM EVENT";
  private static final String ADD_EVENT_STATEMENT = " INSERT INTO EVENT (id, start_date_time, end_date_time, summary, location)"
      + " VALUES (?, ?, ?, ?, ?)";
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
        int idOfEvent = events.getInt("id");
        String startDateTime = events.getString("start_date_time");
        String endDateTime = events.getString("end_date_time");
        String summary = events.getString("summary");
        String location = events.getString("location");
        allEvents.add(new Event(idOfEvent, startDateTime, endDateTime, summary, location));
      }
      return allEvents;
    } catch (SQLException exception) {
      exception.printStackTrace();
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }

  public void addEvent(Event newEvent) {
    try (PreparedStatement addEvent = databaseConnection.prepareStatement(ADD_EVENT_STATEMENT)) {
      addEvent.setInt(1, newEvent.getId());
      addEvent.setString(2, newEvent.getStartDateTime());
      addEvent.setString(3, newEvent.getEndDateTime());
      addEvent.setString(4, newEvent.getSummary());
      addEvent.setString(5, newEvent.getLocation());
      addEvent.executeUpdate();
    } catch (SQLException exception) {
      exception.printStackTrace();
      throw new DatabaseException(DATABASE_EXCEPTION_MESSAGE);
    }
  }
}
