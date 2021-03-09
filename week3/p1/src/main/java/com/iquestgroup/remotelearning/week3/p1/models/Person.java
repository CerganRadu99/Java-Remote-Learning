package com.iquestgroup.remotelearning.week3.p1.models;

public abstract class Person {

  private static final String STRING_DELIMITER = " ";
  private String[] firstname;
  private String surname;
  protected final int monthOfBirth;
  protected final int dayOfBirth;
  protected final int yearOfBirth;
  protected String city;
  protected static final int DIFFERENCE_BETWEEN_LAST_INDEX_STRING_DELIMITER_AND_YEAR = 1;

  protected Person(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
      int yearOfBirth, String city) {
    this.firstname = firstname;
    this.surname = surname;
    this.monthOfBirth = monthOfBirth;
    this.dayOfBirth = dayOfBirth;
    this.yearOfBirth = yearOfBirth;
    this.city = city;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (String currentFirstname : firstname) {
      stringBuilder.append(currentFirstname);
      stringBuilder.append(STRING_DELIMITER);
    }
    stringBuilder.append(surname);
    return stringBuilder.toString();
  }

  public abstract String selfDescribe();

  public abstract String getBirthDate();
}
