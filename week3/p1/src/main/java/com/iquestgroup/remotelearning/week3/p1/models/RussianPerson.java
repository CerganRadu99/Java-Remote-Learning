package com.iquestgroup.remotelearning.week3.p1.models;

import java.util.Calendar;

public class RussianPerson extends Person {

  public RussianPerson(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
      int yearOfBirth, String city) {
    super(firstname, surname, monthOfBirth, dayOfBirth, yearOfBirth, city);
  }

  @Override
  public String selfDescribe() {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int age = currentYear - yearOfBirth;
    return "Меня зовут " + super.toString() + ",мне " + age + " лет, я живу в городе " + city;
  }

  @Override
  public String getBirthDate() {
    return monthOfBirth + "." + dayOfBirth + "." + yearOfBirth;
  }
}
