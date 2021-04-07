package com.iquestgroup.remotelearning.week9.w9p3;

import java.util.ArrayList;
import java.util.Objects;

public class GenericPriorityQueue<E extends Comparable<E>> implements Comparable<GenericPriorityQueue<E>> {

  private static final int DEFAULT_INITIAL_CAPACITY = 10000;
  private final ArrayList<E> queue;
  private int size;

  public GenericPriorityQueue() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public GenericPriorityQueue(int maxSize) {
    if (maxSize < 1) {
      throw new IllegalArgumentException();
    }
    this.queue = new ArrayList<>(maxSize);
    this.size = -1;
  }

  public void insert(E e) {
    queue.add(e);
    size = size + 1;

    shiftUp(size);
  }

  public E remove() {
    E result = queue.get(0);

    queue.set(0, queue.get(size));
    size = size - 1;

    shiftDown(0);
    queue.remove(queue.size() - 1);
    return result;
  }

  public void clear() {
    queue.clear();
  }

  public E head() {
    return queue.get(0);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int compareTo(GenericPriorityQueue<E> genericPriorityQueue) {
    return this.head().compareTo(genericPriorityQueue.head());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericPriorityQueue<?> that = (GenericPriorityQueue<?>) o;
    return size == that.size && Objects.equals(queue, that.queue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queue, size);
  }

  private void shiftUp(int i) {
    while (i > 0 && queue.get(parent(i)).compareTo(queue.get(i)) < 0) {
      swap(parent(i), i);
      i = parent(i);
    }
  }

  private void shiftDown(int i) {
    int maxIndex = i;
    int l = leftChild(i);
    if (l <= size && queue.get(l).compareTo(queue.get(maxIndex)) > 0) {
      maxIndex = l;
    }
    int r = rightChild(i);
    if (r <= size && queue.get(r).compareTo(queue.get(maxIndex)) > 0) {
      maxIndex = r;
    }
    if (i != maxIndex) {
      swap(i, maxIndex);
      shiftDown(maxIndex);
    }
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int leftChild(int i) {
    return ((2 * i) + 1);
  }

  private int rightChild(int i) {
    return ((2 * i) + 2);
  }

  private void swap(int i, int j) {
    E temp = queue.get(i);
    queue.set(i, queue.get(j));
    queue.set(j, temp);
  }
}
