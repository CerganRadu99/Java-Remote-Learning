package com.iquestgroup.remotelearning.week9.w9p2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GenericBubbleSortTest {

  public static final List<Integer> SORTED_INTEGER_COLLECTION;
  public static final List<Double> SORTED_DOUBLE_COLLECTION;
  public static final List<String> SORTED_STRING_COLLECTION;
  public static final List<Person> SORTED_PERSON_COLLECTION;
  public static final Integer[] SORTED_INTEGER_ARRAY;
  public static final Double[] SORTED_DOUBLE_ARRAY;
  public static final String[] SORTED_STRING_ARRAY;
  public static final Person[] SORTED_PERSON_ARRAY;

  static {
    SORTED_INTEGER_ARRAY = new Integer[]{-103, -12, -9, 0, 9, 13, 20, 31, 45, 99, 99, 234};
    SORTED_DOUBLE_ARRAY = new Double[]{-45.83, -34.12, -3.45, -2.2, 3.13, 4.9, 8.01, 12.11, 13.99, 99.78};
    SORTED_STRING_ARRAY = new String[]{"actually", "calculating", "defective", "disgusting", "plantation", "plucky", "snake", "surround", "tacit",
        "three"};
    SORTED_PERSON_ARRAY = new Person[]{new Person("Darius", 8), new Person("Ionel", 19), new Person("Radu", 21), new Person("Gigel", 31),
        new Person("Marian", 45)};
    SORTED_INTEGER_COLLECTION = new ArrayList<>(Arrays.asList(SORTED_INTEGER_ARRAY));
    SORTED_DOUBLE_COLLECTION = new LinkedList<>(Arrays.asList(SORTED_DOUBLE_ARRAY));
    SORTED_STRING_COLLECTION = new ArrayList<>(Arrays.asList(SORTED_STRING_ARRAY));
    SORTED_PERSON_COLLECTION = new LinkedList<>(Arrays.asList(SORTED_PERSON_ARRAY));
  }

  private GenericBubbleSort genericBubbleSort;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testBubbleSortCollectionOfIntegers() {
    Collection<Integer> unsortedIntegerCollection = new ArrayList<>(Arrays.asList(9, -12, 13, 45, 99, -103, 234, 31, 99, 20, -9, 0));
    List<Integer> sortedIntegerCollection = (List<Integer>) genericBubbleSort.sort(unsortedIntegerCollection);
    for (int index = 0; index < sortedIntegerCollection.size(); index++) {
      int expectedResult = SORTED_INTEGER_COLLECTION.get(index);
      int actualResult = sortedIntegerCollection.get(index);
      assertEquals(expectedResult, actualResult);
    }
  }

  @Test
  public void testBubbleSortCollectionOfDoubles() {
    Collection<Double> unsortedDoubleCollection = new LinkedList<>(Arrays.asList(-2.2, 3.13, 4.90, 12.11, -3.45, 8.01, 99.78, -34.12, 13.99, -45.83));
    List<Double> sortedDoubleCollection = (List<Double>) genericBubbleSort.sort(unsortedDoubleCollection);
    for (int index = 0; index < sortedDoubleCollection.size(); index++) {
      double expectedResult = SORTED_DOUBLE_COLLECTION.get(index);
      double actualResult = sortedDoubleCollection.get(index);
      assertEquals(expectedResult, actualResult, 0);
    }
  }

  @Test
  public void testBubbleSortCollectionOfStrings() {
    Collection<String> unsortedStringCollection = new HashSet<>(
        Arrays.asList("surround", "three", "plucky", "defective", "snake", "tacit", "disgusting", "actually", "calculating", "plantation"));
    List<String> sortedStringCollection = (List<String>) genericBubbleSort.sort(unsortedStringCollection);
    for (int index = 0; index < sortedStringCollection.size(); index++) {
      String expectedResult = SORTED_STRING_COLLECTION.get(index);
      String actualResult = sortedStringCollection.get(index);
      assertEquals(expectedResult, actualResult);
    }
  }

  @Test
  public void testBubbleSortCollectionOfPersons() {
    Collection<Person> unsortedPersonCollection = new LinkedHashSet<>(
        Arrays.asList(new Person("Marian", 45), new Person("Gigel", 31), new Person("Radu", 21), new Person("Darius", 8), new Person("Ionel", 19)));
    List<Person> sortedPersonCollection = (List<Person>) genericBubbleSort.sort(unsortedPersonCollection);
    for (int index = 0; index < sortedPersonCollection.size(); index++) {
      String expectedName = SORTED_PERSON_COLLECTION.get(index).getName();
      String actualName = sortedPersonCollection.get(index).getName();
      int expectedAge = SORTED_PERSON_COLLECTION.get(index).getAge();
      int actualAge = sortedPersonCollection.get(index).getAge();
      assertEquals(expectedName, actualName);
      assertEquals(expectedAge, actualAge);
    }
  }

  @Test
  public void testBubbleSortArrayOfIntegers() {
    Integer[] unsortedIntegerArray = new Integer[]{9, -12, 13, 45, 99, -103, 234, 31, 99, 20, -9, 0};
    Integer[] sortedIntegerArray = genericBubbleSort.sort(unsortedIntegerArray);
    for (int index = 0; index < sortedIntegerArray.length; index++) {
      int expectedResult = SORTED_INTEGER_ARRAY[index];
      int actualResult = sortedIntegerArray[index];
      assertEquals(expectedResult, actualResult);
    }
  }

  @Test
  public void testBubbleSortArrayOfDoubles() {
    Double[] unsortedDoubleArray = new Double[]{-2.2, 3.13, 4.90, 12.11, -3.45, 8.01, 99.78, -34.12, 13.99, -45.83};
    Double[] sortedDoubleArray = genericBubbleSort.sort(unsortedDoubleArray);
    for (int index = 0; index < sortedDoubleArray.length; index++) {
      double expectedResult = SORTED_DOUBLE_ARRAY[index];
      double actualResult = sortedDoubleArray[index];
      assertEquals(expectedResult, actualResult, 0);
    }
  }

  @Test
  public void testBubbleSortArrayOfStrings() {
    String[] unsortedStringArray = new String[]{"surround", "three", "plucky", "defective", "snake", "tacit", "disgusting", "actually", "calculating",
        "plantation"};
    String[] sortedStringArray = genericBubbleSort.sort(unsortedStringArray);
    for (int index = 0; index < sortedStringArray.length; index++) {
      String expectedResult = SORTED_STRING_ARRAY[index];
      String actualResult = sortedStringArray[index];
      assertEquals(expectedResult, actualResult);
    }
  }

  @Test
  public void testBubbleSortArrayOfPersons() {
    Person[] unsortedPersonArray = new Person[]{new Person("Marian", 45), new Person("Gigel", 31), new Person("Radu", 21), new Person("Darius", 8),
        new Person("Ionel", 19)};
    Person[] sortedPersonArray = genericBubbleSort.sort(unsortedPersonArray);
    for (int index = 0; index < sortedPersonArray.length; index++) {
      String expectedName = SORTED_PERSON_ARRAY[index].getName();
      String actualName = sortedPersonArray[index].getName();
      int expectedAge = SORTED_PERSON_ARRAY[index].getAge();
      int actualAge = sortedPersonArray[index].getAge();
      assertEquals(expectedName, actualName);
      assertEquals(expectedAge, actualAge);
    }
  }

  private void initData() {
    genericBubbleSort = new GenericBubbleSort();
  }
}
