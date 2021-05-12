package com.iquestgroup.remotelearning.week14.w14p4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class PersonHandlerTest {

  public static final int OLDER_THAN_AGE;
  public static final int YOUNGER_THAN_AGE;
  public static final List<String> EXPECTED_PERSONS_OLDER_THAN_GIVEN_AGE;
  public static final Map<Integer, List<String>> EXPECTED_PERSONS_GROUPED_BY_AGE;
  public static final String EXPECTED_OLDEST_PERSON;

  static {
    OLDER_THAN_AGE = 18;
    YOUNGER_THAN_AGE = 80;
    EXPECTED_OLDEST_PERSON = "Vasile";
    EXPECTED_PERSONS_OLDER_THAN_GIVEN_AGE = new ArrayList<>(Arrays.asList("Vasile", "Mihai"));
    EXPECTED_PERSONS_GROUPED_BY_AGE = new HashMap<>();
    EXPECTED_PERSONS_GROUPED_BY_AGE.put(17, Collections.singletonList("Ionut"));
    EXPECTED_PERSONS_GROUPED_BY_AGE.put(18, Arrays.asList("Maria", "Marioara"));
    EXPECTED_PERSONS_GROUPED_BY_AGE.put(20, Collections.singletonList("Mihai"));
    EXPECTED_PERSONS_GROUPED_BY_AGE.put(21, Collections.singletonList("Vasile"));
    EXPECTED_PERSONS_GROUPED_BY_AGE.put(15, Collections.singletonList("Marcel"));
  }

  private PersonsHandler personsHandler;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testGetPersonsOlderThanGivenAge() {
    List<String> actualPersonsOlderThanGivenAge = personsHandler.getPersonsOlderThanGivenAge(OLDER_THAN_AGE);
    assertEquals(EXPECTED_PERSONS_OLDER_THAN_GIVEN_AGE.size(), actualPersonsOlderThanGivenAge.size());
    for (int indexOfPerson = 0; indexOfPerson < actualPersonsOlderThanGivenAge.size(); indexOfPerson++) {
      assertEquals(EXPECTED_PERSONS_OLDER_THAN_GIVEN_AGE.get(indexOfPerson), actualPersonsOlderThanGivenAge.get(indexOfPerson));
    }
  }

  @Test
  public void testGetOldestPerson() {
    String actualOldestPerson = personsHandler.getOldestPerson();
    assertEquals(EXPECTED_OLDEST_PERSON, actualOldestPerson);
  }

  @Test
  public void testCheckIfAllYoungerThanGivenAge() {
    boolean actualResult = personsHandler.checkIfAllYoungerThanGivenAge(YOUNGER_THAN_AGE);
    assertTrue(actualResult);
  }

  @Test
  public void testGetPersonsGroupedByAge() {
    Map<Integer, List<String>> actualPersonsGroupedByAge = personsHandler.getPersonsGroupedByAge();
    assertEquals(EXPECTED_PERSONS_GROUPED_BY_AGE.size(), actualPersonsGroupedByAge.size());
    // asserturi pentru fiecare entry din map
  }

  private void initData() {
    List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
    personsHandler = new PersonsHandler(persons);
  }
}
