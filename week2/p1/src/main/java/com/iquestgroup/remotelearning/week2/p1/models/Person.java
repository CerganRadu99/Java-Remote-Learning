package com.iquestgroup.remotelearning.week2.p1.models;

public class Person {

  private static final String SPACE_DELIMITER = " ";
  private static final int START_INDEX_FIRST_LETTER = 0;
  private String[] firstname;
  private String surname;

  public Person(String[] firstname, String surname) {
    this.firstname = firstname;
    this.surname = surname;
  }

  public Person(String fullName) {
    splitFullName(fullName);
  }

  private void splitFullName(String fullName) {
    int lastSpaceIndex = fullName.lastIndexOf(SPACE_DELIMITER);
    surname = fullName.substring(lastSpaceIndex).trim();
    String firstnameAsString = fullName.substring(START_INDEX_FIRST_LETTER, lastSpaceIndex);
    firstname = firstnameAsString.split(SPACE_DELIMITER);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (String currentFirstname : firstname) {
      stringBuilder.append(currentFirstname + SPACE_DELIMITER);
    }
    stringBuilder.append(surname);
    return stringBuilder.toString();
  }
}
