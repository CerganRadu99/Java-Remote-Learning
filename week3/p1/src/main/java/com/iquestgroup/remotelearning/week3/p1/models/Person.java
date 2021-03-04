package com.iquestgroup.remotelearning.week3.p1.models;

public abstract class Person {

  protected String[] firstname;
  protected String surname;
  protected final int monthOfBirth;
  protected final int dayOfBirth;
  protected final int yearOfBirth;
  protected String city;
  private static final int INITIALIZER_DATE_OF_BIRTH = 0;

  public Person(String[] firstname, String surname) {
    this.firstname = firstname;
    this.surname = surname;
    this.monthOfBirth = INITIALIZER_DATE_OF_BIRTH;
    this.dayOfBirth = INITIALIZER_DATE_OF_BIRTH;
    this.yearOfBirth = INITIALIZER_DATE_OF_BIRTH;
  }

  public Person(String fullName) {
    splitFullName(fullName);
    this.monthOfBirth = INITIALIZER_DATE_OF_BIRTH;
    this.dayOfBirth = INITIALIZER_DATE_OF_BIRTH;
    this.yearOfBirth = INITIALIZER_DATE_OF_BIRTH;
  }

  public Person(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
      int yearOfBirth, String city) {
    this.firstname = firstname;
    this.surname = surname;
    this.monthOfBirth = monthOfBirth;
    this.dayOfBirth = dayOfBirth;
    this.yearOfBirth = yearOfBirth;
    this.city = city;
  }

  private void splitFullName(String fullName) {
    int lastSpaceIndex = fullName.lastIndexOf(" ");
    surname = fullName.substring(lastSpaceIndex).trim();
    String firstnameAsString = fullName.substring(0, lastSpaceIndex);
    firstname = firstnameAsString.split(" ");
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (String currentFirstname : firstname) {
      stringBuilder.append(currentFirstname + " ");
    }
    stringBuilder.append(surname);
    return stringBuilder.toString();
  }

  public abstract String selfDescribe();

  public abstract String getBirthDate();
}
