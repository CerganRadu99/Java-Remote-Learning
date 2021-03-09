package com.iquestgroup.remotelearning.week3.p1.models;

import java.util.Calendar;

public class AmericanPerson extends Person {

  private static final String BIRTH_DELIMITER = "-";

  public AmericanPerson(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
      int yearOfBirth, String city) {
    super(firstname, surname, monthOfBirth, dayOfBirth, yearOfBirth, city);
  }

  @Override
  public String selfDescribe() {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    String dateOfBirth = getBirthDate();
    int startIndexYear = dateOfBirth.lastIndexOf(BIRTH_DELIMITER)
        + DIFFERENCE_BETWEEN_LAST_INDEX_STRING_DELIMITER_AND_YEAR;
    int age = currentYear - Integer.parseInt(dateOfBirth.substring(startIndexYear));
    return "My name is " + super.toString() + ",I am " + age
        + " years old and I live in the city of " + city;
  }

  @Override
  public String getBirthDate() {
    return monthOfBirth + BIRTH_DELIMITER + dayOfBirth + BIRTH_DELIMITER + yearOfBirth;
  }
}
