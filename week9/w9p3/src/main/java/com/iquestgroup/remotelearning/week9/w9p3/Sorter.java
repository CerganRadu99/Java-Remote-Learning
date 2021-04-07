package com.iquestgroup.remotelearning.week9.w9p3;

import java.util.List;

public class Sorter {

  public <E extends Comparable<E>> List<E> sort(List<E> unsortedList) {
    GenericPriorityQueue<E> genericPriorityQueue = new GenericPriorityQueue<>();
    for (E currentElement : unsortedList) {
      genericPriorityQueue.insert(currentElement);
    }
    int index = unsortedList.size() - 1;
    while (!genericPriorityQueue.isEmpty()) {
      unsortedList.set(index, genericPriorityQueue.remove());
      index--;
    }
    return unsortedList;
  }
}
