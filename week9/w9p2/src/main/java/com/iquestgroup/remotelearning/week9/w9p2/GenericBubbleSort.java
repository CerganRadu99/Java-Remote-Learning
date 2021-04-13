package com.iquestgroup.remotelearning.week9.w9p2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericBubbleSort {

  public <T extends Comparable<T>> T[] sort(T[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j].compareTo(array[j + 1]) > 0) {
          changePositionFromArray(array, j);
        }
      }
    }
    return array;
  }

  public <T extends Comparable<T>> Collection<T> sort(Collection<T> collection) {
    List<T> listToSort = new ArrayList<>(collection);
    for (int i = 0; i < listToSort.size() - 1; i++) {
      for (int j = 0; j < listToSort.size() - i - 1; j++) {
        if (listToSort.get(j).compareTo(listToSort.get(j + 1)) > 0) {
          changePositionFromCollection(listToSort, j);
        }
      }
    }
    return listToSort;
  }

  private <T> void changePositionFromArray(T[] array, int positionToChange) {
    T objectToMove = array[positionToChange];
    array[positionToChange] = array[positionToChange + 1];
    array[positionToChange + 1] = objectToMove;
  }

  private <T> void changePositionFromCollection(List<T> collection, int positionToChange) {
    T objectToMove = collection.get(positionToChange);
    collection.set(positionToChange, collection.get(positionToChange + 1));
    collection.set(positionToChange + 1, objectToMove);
  }
}
