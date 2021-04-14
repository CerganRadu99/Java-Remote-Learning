package com.iquestgroup.remotelearning.week9.w9p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {

  public <E extends Comparable<E>> List<E> sort(List<E> unsortedList) {
    List<E> sortedList = new ArrayList<>();
    GenericPriorityQueue<E> genericPriorityQueue = new GenericPriorityQueue<>();
    for (E currentElement : unsortedList) {
      genericPriorityQueue.insert(currentElement);
    }
    while (!genericPriorityQueue.isEmpty()) {
      sortedList.add(genericPriorityQueue.remove());
    }
    Collections.reverse(sortedList);
    return sortedList;
  }
}
