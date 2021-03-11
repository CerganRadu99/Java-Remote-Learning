package com.iquestgroup.remotelearning.week3.w3p1;

import com.iquestgroup.remotelearning.week3.w3p1.models.AmericanPerson;
import com.iquestgroup.remotelearning.week3.w3p1.models.FrenchPerson;
import com.iquestgroup.remotelearning.week3.w3p1.models.Person;
import com.iquestgroup.remotelearning.week3.w3p1.models.RussianPerson;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Person> persons = new ArrayList<Person>();
    persons.add(new FrenchPerson(new String[]{"Lucas", "Enzo"}, "Ethan", 7, 3, 1999, "Bordeaux"));
    persons.add(
        new AmericanPerson(new String[]{"John", "Wesley"}, "Powell", 9, 22, 1968, "Los Angeles"));
    persons
        .add(new RussianPerson(new String[]{"Egor", "Sergei"}, "Babikov", 11, 19, 2005, "Moscova"));
    for (Person currentPerson : persons) {
      System.out.println(currentPerson.selfDescribe());
    }
  }
}
