package com.iquestgroup.remotelearning.week14.w14p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonsHandler {

  private static final int INDEX_OLDEST_PERSON = 0;
  private static final int AGE_INDEX = 0;
  private static final int NAME_INDEX = 1;
  private static final String STRING_DELIMITER = ":";
  private final List<String> persons;

  public PersonsHandler(List<String> persons) {
    this.persons = persons;
  }

  public List<String> getPersonsOlderThanGivenAge(int age) {
    Stream<String> personsAsStream = persons.stream();
    Stream<String> olderPersons = personsAsStream.filter(person -> {
      int ageOfPerson = getAge(person);
      return ageOfPerson > age;
    });
    return getNameOfPersons(olderPersons);
  }

  public String getOldestPerson() {
    Stream<String> personsAsStream = persons.stream();
    Optional<String> oldestPerson = personsAsStream.reduce((firstPerson, secondPerson) -> {
      int ageFirstPerson = getAge(firstPerson);
      int ageSecondPerson = getAge(secondPerson);
      return ageFirstPerson > ageSecondPerson ? firstPerson : secondPerson;
    });
    Stream<String> oldestPersonAsStream = oldestPerson.stream();
    return getNameOfPersons(oldestPersonAsStream).get(INDEX_OLDEST_PERSON);
  }

  public boolean checkIfAllYoungerThanGivenAge(int age) {
    Stream<String> personsAsStream = persons.stream();
    return personsAsStream.allMatch(person -> {
      int ageOfPerson = getAge(person);
      return ageOfPerson < age;
    });
  }

  public Map<Integer, List<String>> getPersonsGroupedByAge() {
    Stream<String> personsAsStream = persons.stream();
    Map<Integer, List<String>> personsGroupedByAge = personsAsStream.collect(Collectors.groupingBy(this::getAge));
    return getNameOfPersonsGroupedByAge(personsGroupedByAge);
  }

  private Map<Integer, List<String>> getNameOfPersonsGroupedByAge(Map<Integer, List<String>> personsGroupedByAge) {
    Map<Integer, List<String>> nameOfPersonsGroupedByAge = new HashMap<>();
    for (Map.Entry<Integer, List<String>> currentPerson : personsGroupedByAge.entrySet()) {
      List<String> nameOfPersons = getNameOfPersons(currentPerson.getValue().stream());
      nameOfPersonsGroupedByAge.put(currentPerson.getKey(), nameOfPersons);
    }
    return nameOfPersonsGroupedByAge;
  }

  private int getAge(String person) {
    String ageOfPersonAsString = person.split(STRING_DELIMITER)[AGE_INDEX];
    return Integer.parseInt(ageOfPersonAsString);
  }

  private List<String> getNameOfPersons(Stream<String> persons) {
    List<String> nameOfPersons = new ArrayList<>();
    for (String currentPerson : persons.collect(Collectors.toList())) {
      nameOfPersons.add(currentPerson.split(STRING_DELIMITER)[NAME_INDEX]);
    }
    return nameOfPersons;
  }
}
