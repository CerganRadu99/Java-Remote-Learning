package com.iquestgroup.remotelearning.week9.w9p3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.iquestgroup.remotelearning.week9.w9p3.exceptions.GenericPriorityQueueEmptyException;
import com.iquestgroup.remotelearning.week9.w9p3.exceptions.GenericPriorityQueueFullException;
import org.junit.Before;
import org.junit.Test;

public class GenericPriorityQueueTest {

  public static final int HEAD_OF_PRIORITY_QUEUE = 33;
  public static final int NUMBER_OF_ELEMENTS = 3;
  public static final int FIRST_NUMBER_TO_INSERT = 19;
  public static final int SECOND_NUMBER_TO_INSERT = 33;
  public static final int THIRD_NUMBER_TO_INSERT = 15;
  private GenericPriorityQueue<Integer> genericPriorityQueue;

  @Before
  public void setup() {
    genericPriorityQueue = new GenericPriorityQueue<>(NUMBER_OF_ELEMENTS);
  }

  @Test(expected = GenericPriorityQueueFullException.class)
  public void testInsertInPriorityQueueWhenIsFull() {
    insert();
    genericPriorityQueue.insert(FIRST_NUMBER_TO_INSERT);
  }

  @Test(expected = GenericPriorityQueueEmptyException.class)
  public void testReturnHeadOfPriorityQueueWhenIsEmpty() {
    genericPriorityQueue.head();
  }

  @Test(expected = GenericPriorityQueueEmptyException.class)
  public void testRemoveFromPriorityQueueWhenIsEmpty() {
    genericPriorityQueue.remove();
  }

  @Test(expected = GenericPriorityQueueEmptyException.class)
  public void testClearPriorityQueueWhenAlreadyEmpty() {
    genericPriorityQueue.clear();
  }

  @Test
  public void testInsertInPriorityQueue() {
    insert();
    assertFalse(genericPriorityQueue.isEmpty());
  }

  @Test
  public void testReturnHeadOfPriorityQueue() {
    insert();
    int actualResult = genericPriorityQueue.head();
    assertEquals(HEAD_OF_PRIORITY_QUEUE, actualResult);
  }

  @Test
  public void testRemoveFromPriorityQueue() {
    insert();
    removeAllElements();
    assertTrue(genericPriorityQueue.isEmpty());
  }

  @Test
  public void testClearPriorityQueue() {
    insert();
    genericPriorityQueue.clear();
    assertTrue(genericPriorityQueue.isEmpty());
  }

  @Test
  public void testCheckIfPriorityQueueIsEmpty() {
    assertTrue(genericPriorityQueue.isEmpty());
  }

  private void insert() {
    genericPriorityQueue.insert(FIRST_NUMBER_TO_INSERT);
    genericPriorityQueue.insert(SECOND_NUMBER_TO_INSERT);
    genericPriorityQueue.insert(THIRD_NUMBER_TO_INSERT);
  }

  private void removeAllElements() {
    for (int iterator = 0; iterator < NUMBER_OF_ELEMENTS; iterator++) {
      genericPriorityQueue.remove();
    }
  }
}
