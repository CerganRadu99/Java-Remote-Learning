package com.iquestgroup.remotelearning.week9.w9p1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;

public class GenericCollectionTest {

  public static final int FIRST_INTEGER_TO_ADD = 30;
  public static final int SECOND_INTEGER_TO_ADD = 99;
  public static final String FIRST_STRING_TO_ADD = "string1";
  public static final String SECOND_STRING_TO_ADD = "string2";

  @Test
  public void testIfMyCollectionImplContainsAnotherCollection() {
    ArrayList<Integer> collection = new ArrayList<>();
    MyCollectionImpl<Integer, ArrayList<Integer>> myCollection = new MyCollectionImpl<>(collection);
    collection.add(FIRST_INTEGER_TO_ADD);
    collection.add(SECOND_INTEGER_TO_ADD);
    myCollection.addAll(collection);
    assertTrue(myCollection.containsAll(collection));
  }

  @Test
  public void testIfMyCollectionImplCanAddAnotherCollection() {
    LinkedList<String> collection = new LinkedList<>();
    MyCollectionImpl<String, LinkedList<String>> myCollection = new MyCollectionImpl<>(collection);
    collection.add(FIRST_STRING_TO_ADD);
    collection.add(SECOND_STRING_TO_ADD);
    assertTrue(myCollection.addAll(collection));
  }
}
