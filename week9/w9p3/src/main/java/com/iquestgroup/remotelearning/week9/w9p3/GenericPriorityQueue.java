package com.iquestgroup.remotelearning.week9.w9p3;

import com.iquestgroup.remotelearning.week9.w9p3.exceptions.GenericPriorityQueueEmptyException;
import com.iquestgroup.remotelearning.week9.w9p3.exceptions.GenericPriorityQueueFullException;
import java.util.ArrayList;

public class GenericPriorityQueue<E extends Comparable<E>> implements Comparable<GenericPriorityQueue<E>> {

  private static final String PQ_FULL_EXCEPTION_MESSAGE = "Priority queue is full!";
  private static final String PQ_EMPTY_EXCEPTION_MESSAGE = "Priority queue is empty!";
  private static final int DEFAULT_INITIAL_CAPACITY = 10000;
  private final ArrayList<E> queue;
  private final int maxSize;
  private int currentIndex;

  public GenericPriorityQueue() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public GenericPriorityQueue(int maxSize) {
    if (maxSize < 1) {
      throw new IllegalArgumentException();
    }
    this.maxSize = maxSize;
    this.queue = new ArrayList<>();
    this.currentIndex = -1;
  }

  public void insert(E e) {
    if (queue.size() == maxSize) {
      throw new GenericPriorityQueueFullException(PQ_FULL_EXCEPTION_MESSAGE);
    }
    queue.add(e);
    currentIndex = currentIndex + 1;

    shiftUp(currentIndex);
  }

  public E remove() {
    if (isEmpty()) {
      throw new GenericPriorityQueueEmptyException(PQ_EMPTY_EXCEPTION_MESSAGE);
    }
    E result = queue.get(0);

    queue.set(0, queue.get(currentIndex));
    currentIndex = currentIndex - 1;

    shiftDown(0);
    queue.remove(queue.size() - 1);
    return result;
  }

  public void clear() {
    if (isEmpty()) {
      throw new GenericPriorityQueueEmptyException(PQ_EMPTY_EXCEPTION_MESSAGE);
    }
    queue.clear();
  }

  public E head() {
    if (isEmpty()) {
      throw new GenericPriorityQueueEmptyException(PQ_EMPTY_EXCEPTION_MESSAGE);
    }
    return queue.get(0);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int compareTo(GenericPriorityQueue<E> genericPriorityQueue) {
    return this.head().compareTo(genericPriorityQueue.head());
  }

  private void shiftUp(int positionToShift) {
    while (positionToShift > 0 && queue.get(getParentIndex(positionToShift)).compareTo(queue.get(positionToShift)) < 0) {
      swap(getParentIndex(positionToShift), positionToShift);
      positionToShift = getParentIndex(positionToShift);
    }
  }

  private void shiftDown(int positionToShift) {
    int maxIndex = positionToShift;
    int leftChildIndex = getLeftChildIndex(positionToShift);
    if (leftChildIndex <= currentIndex && queue.get(leftChildIndex).compareTo(queue.get(maxIndex)) > 0) {
      maxIndex = leftChildIndex;
    }
    int rightChildIndex = getRightChildIndex(positionToShift);
    if (rightChildIndex <= currentIndex && queue.get(rightChildIndex).compareTo(queue.get(maxIndex)) > 0) {
      maxIndex = rightChildIndex;
    }
    if (positionToShift != maxIndex) {
      swap(positionToShift, maxIndex);
      shiftDown(maxIndex);
    }
  }

  private int getParentIndex(int i) {
    return (i - 1) / 2;
  }

  private int getLeftChildIndex(int i) {
    return ((2 * i) + 1);
  }

  private int getRightChildIndex(int i) {
    return ((2 * i) + 2);
  }

  private void swap(int parentIndex, int childIndex) {
    E objectToMove = queue.get(parentIndex);
    queue.set(parentIndex, queue.get(childIndex));
    queue.set(childIndex, objectToMove);
  }
}
