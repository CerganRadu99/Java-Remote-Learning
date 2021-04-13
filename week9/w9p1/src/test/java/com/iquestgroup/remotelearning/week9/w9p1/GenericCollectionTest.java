package com.iquestgroup.remotelearning.week9.w9p1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class GenericCollectionTest {

  public static final Collection<String> STRING_COLLECTION_TEST;
  public static final Collection<Integer> INTEGER_COLLECTION_TEST;

  static{
    STRING_COLLECTION_TEST = new ArrayList<>(Arrays.asList("string1", "string2", "string3"));
    INTEGER_COLLECTION_TEST = new HashSet<>(Arrays.asList(99, -13, 22));
  }

  private MyCollection<String> stringCollection;
  private MyCollection<Integer> integerCollection;

  @Before
  public void setup(){
    initData();
  }

  @Test
  public void testIfStringCollectionContainsAnotherCollection() {
    stringCollection.addAll(STRING_COLLECTION_TEST);
    assertTrue(stringCollection.containsAll(STRING_COLLECTION_TEST));
  }

  @Test
  public void testIfStringCollectionCanAddAnotherCollection() {
    assertTrue(stringCollection.addAll(STRING_COLLECTION_TEST));
  }

  @Test
  public void testIfIntegerCollectionContainsAnotherCollection() {
    integerCollection.addAll(INTEGER_COLLECTION_TEST);
    assertTrue(integerCollection.containsAll(INTEGER_COLLECTION_TEST));
  }

  @Test
  public void testIfIntegerCollectionCanAddAnotherCollection() {
    assertTrue(integerCollection.addAll(INTEGER_COLLECTION_TEST));
  }

  private void initData(){
    stringCollection = new StringCollection();
    integerCollection = new IntegerCollection();
  }
}
