package com.iquestgroup.remotelearning.week3.p1.models;

import java.util.Calendar;

public class AmericanPerson extends Person {

  public AmericanPerson(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
      int yearOfBirth, String city) {
    super(firstname, surname, monthOfBirth, dayOfBirth, yearOfBirth, city);
  }

  @Override
  public String selfDescribe() {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int age = currentYear - yearOfBirth;
    return "My name is " + super.toString() + ",I am " + age
        + " years old and I live in the city of " + city;
  }

  @Override
  public String getBirthDate() {
    return monthOfBirth + "-" + dayOfBirth + "-" + yearOfBirth;
  }
}
