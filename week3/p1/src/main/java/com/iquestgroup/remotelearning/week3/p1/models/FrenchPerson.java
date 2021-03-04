package com.iquestgroup.remotelearning.week3.p1.models;


import java.util.Calendar;

public class FrenchPerson extends Person {

  public FrenchPerson(String[] firstname, String surname, int monthOfBirth, int dayOfBirth,
      int yearOfBirth, String city) {
    super(firstname, surname, monthOfBirth, dayOfBirth, yearOfBirth, city);
  }

  @Override
  public String selfDescribe() {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int age = currentYear - yearOfBirth;
    return "Je m'appelle " + super.toString() + ", j'ai " + age
        + " ans et j'habite dans la ville de " + city;
  }

  @Override
  public String getBirthDate() {
    return monthOfBirth + "/" + dayOfBirth + "/" + yearOfBirth;
  }
}
