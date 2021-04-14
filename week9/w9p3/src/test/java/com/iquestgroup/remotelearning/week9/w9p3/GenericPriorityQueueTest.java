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
  private GenericPriorityQueue<Integer> genericPriorityQueue;

  @Before
  public void setup() {
    genericPriorityQueue = new GenericPriorityQueue<>(NUMBER_OF_ELEMENTS);
  }

  @Test(expected = GenericPriorityQueueFullException.class)
  public void testInsertInPriorityQueueWhenIsFull() {
    insert();
    genericPriorityQueue.insert(19);
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
    genericPriorityQueue.insert(15);
    genericPriorityQueue.insert(33);
    genericPriorityQueue.insert(19);
  }

  private void removeAllElements() {
    for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
      genericPriorityQueue.remove();
    }
  }
}
