package com.iquestgroup.remotelearning.week2.p1;

import com.iquestgroup.remotelearning.week2.p1.models.Person;

public class Main {

  public static void main(String[] args) {
    String[] firstname = {"Robert", "Kaysen"};
    Person firstPerson = new Person(firstname, "Booth");
    System.out.println(firstPerson);

    Person secondPerson = new Person("Harrison James Beckett Cale Dean");
    System.out.println(secondPerson);
  }
}
