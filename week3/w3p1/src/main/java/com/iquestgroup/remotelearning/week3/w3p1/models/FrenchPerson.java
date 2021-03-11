package com.iquestgroup.remotelearning.week3.w3p1.models;


import java.util.Calendar;

public class FrenchPerson extends Person {

  private static final String BIRTH_DELIMITER = "/";

  public FrenchPerson(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
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
    return "Je m'appelle " + super.toString() + ", j'ai " + age
        + " ans et j'habite dans la ville de " + city;
  }

  @Override
  public String getBirthDate() {
    return monthOfBirth + BIRTH_DELIMITER + dayOfBirth + BIRTH_DELIMITER + yearOfBirth;
  }
}
