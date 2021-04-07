package com.iquestgroup.remotelearning.week9.w9p2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GenericBubbleSortTest {

  public static final Integer[] SORTED_INTEGER_COLLECTION;
  public static final Double[] SORTED_DOUBLE_COLLECTION;
  public static final String[] SORTED_STRING_COLLECTION;
  public static final Person[] SORTED_PERSON_COLLECTION;

  static {
    SORTED_INTEGER_COLLECTION = new Integer[]{-103, -12, -9, 0, 9, 13, 20, 31, 45, 99, 99, 234};
    SORTED_DOUBLE_COLLECTION = new Double[]{-45.83, -34.12, -3.45, -2.2, 3.13, 4.9, 8.01, 12.11, 13.99, 99.78};
    SORTED_STRING_COLLECTION = new String[]{"actually", "calculating", "defective", "disgusting", "plantation", "plucky", "snake", "surround",
        "tacit", "three"};
    SORTED_PERSON_COLLECTION = new Person[]{new Person("Darius", 8), new Person("Ionel", 19), new Person("Radu", 21), new Person("Gigel", 31),
        new Person("Marian", 45)};
  }

  private GenericBubbleSort genericBubbleSort;
  
  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testBubbleSortCollectionOfIntegers() {
    Integer[] integerCollection = new Integer[]{9, -12, 13, 45, 99, -103, 234, 31, 99, 20, -9, 0};
    genericBubbleSort.sort(integerCollection);
    for (int index = 0; index < integerCollection.length; index++) {
      int expectedResult = SORTED_INTEGER_COLLECTION[index];
      int actualResult = integerCollection[index];
      assertEquals(expectedResult, actualResult);
    }
  }

  @Test
  public void testBubbleSortCollectionOfDoubles() {
    Double[] doubleCollection = new Double[]{-2.2, 3.13, 4.90, 12.11, -3.45, 8.01, 99.78, -34.12, 13.99, -45.83};
    genericBubbleSort.sort(doubleCollection);
    for (int index = 0; index < doubleCollection.length; index++) {
      double expectedResult = SORTED_DOUBLE_COLLECTION[index];
      double actualResult = doubleCollection[index];
      assertEquals(expectedResult, actualResult, 0);
    }
  }

  @Test
  public void testBubbleSortCollectionOfStrings() {
    String[] stringCollection = new String[]{"surround", "three", "plucky", "defective", "snake", "tacit", "disgusting", "actually", "calculating",
        "plantation"};
    genericBubbleSort.sort(stringCollection);
    for (int index = 0; index < stringCollection.length; index++) {
      String expectedResult = SORTED_STRING_COLLECTION[index];
      String actualResult = stringCollection[index];
      assertEquals(expectedResult, actualResult);
    }
  }

  @Test
  public void testBubbleSortCollectionOfPersons() {
    Person[] personCollection = new Person[]{new Person("Marian", 45), new Person("Gigel", 31), new Person("Radu", 21), new Person("Darius", 8),
        new Person("Ionel", 19)};
    genericBubbleSort.sort(personCollection);
    for (int index = 0; index < personCollection.length; index++) {
      String expectedName = SORTED_PERSON_COLLECTION[index].getName();
      String actualName = personCollection[index].getName();
      int expectedAge = SORTED_PERSON_COLLECTION[index].getAge();
      int actualAge = personCollection[index].getAge();
      assertEquals(expectedName, actualName);
      assertEquals(expectedAge, actualAge);
    }
  }

  private void initData() {
    genericBubbleSort = new GenericBubbleSort();
  }
}
