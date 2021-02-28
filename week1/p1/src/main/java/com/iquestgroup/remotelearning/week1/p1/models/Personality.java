package com.iquestgroup.remotelearning.week1.p1.models;

public class Personality {

  private String firstName;
  private String lastName;
  private final int dateOfBirth;
  private int dateOfDeath;

  public Personality(String firstName, String lastName, int dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.dateOfDeath = 0;
  }

  public Personality(String firstName, String lastName, int dateOfBirth, int dateOfDeath) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.dateOfDeath = dateOfDeath;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getDateOfBirth() {
    return dateOfBirth;
  }

  public int getDateOfDeath() {
    return dateOfDeath;
  }

  public boolean equals(Object object) {
    if (object instanceof Personality) {
      Personality personality = (Personality) object;
      return (personality.getFirstName().equals(this.firstName) && personality.getLastName()
          .equals(this.lastName) && personality.getDateOfBirth() == this.dateOfBirth
          && personality.getDateOfDeath() == this.dateOfDeath);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return dateOfBirth * 20 + dateOfDeath * 20 + firstName.hashCode() + lastName.hashCode();
  }

  @java.lang.Override
  public java.lang.String toString() {
    if (dateOfDeath == 0) {
      return this.firstName + " " + lastName + " " + "(" + dateOfBirth + "-" + " " + ")";
    } else {
      return this.firstName + " " + lastName + " " + "(" + dateOfBirth + "-" + dateOfDeath + ")";
    }
  }
}