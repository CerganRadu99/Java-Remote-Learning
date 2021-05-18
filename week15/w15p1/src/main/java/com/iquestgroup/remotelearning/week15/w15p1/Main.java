package com.iquestgroup.remotelearning.week15.w15p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

  public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/mydb";
  public static final String USER = "test";
  public static final String PASSWORD = "test";

  public static void main(String[] args) {
    try {
      Class.forName(DRIVER_PATH);
      Connection databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
      EventDao eventDao = new EventDao(databaseConnection);
      EventManagementService eventManagementService = new EventManagementService(eventDao);
      eventManagementService.addEvent();
      eventManagementService.listNextWeekendEvents();
      eventManagementService.listEventsFromDate();
      eventManagementService.listEventsFromInterval();
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
  }
}