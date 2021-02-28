package com.iquestgroup.remotelearning.week2.p1;

public class Person {

  private String firstname;
  private String surname;

  Person(String firstname, String surname) {
    this.firstname = firstname;
    this.surname = surname;
  }

  Person(String fullName) {
    splitFullName(fullName);
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  private void splitFullName(String fullName) {
    int lastSpaceIndex = fullName.lastIndexOf(" ");
    surname = fullName.substring(lastSpaceIndex).trim();
    firstname = fullName.substring(0, lastSpaceIndex);
  }

  @Override
  public String toString() {
    return firstname + " " + surname;
  }
}
