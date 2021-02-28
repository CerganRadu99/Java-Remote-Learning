package com.iquestgroup.remotelearning.week2.p1.models;

public class Person {

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
}
