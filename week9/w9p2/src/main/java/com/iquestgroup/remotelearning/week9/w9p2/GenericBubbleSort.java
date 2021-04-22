package com.iquestgroup.remotelearning.week9.w9p2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericBubbleSort {

  public <T extends Comparable<T>> T[] sort(T[] array) {
    for (int iterator = 0; iterator < array.length - 1; iterator++) {
      for (int indexFirstElementToCompare = 0; indexFirstElementToCompare < array.length - iterator - 1; indexFirstElementToCompare++) {
        if (array[indexFirstElementToCompare].compareTo(array[indexFirstElementToCompare + 1]) > 0) {
          changePositionFromArray(array, indexFirstElementToCompare);
        }
      }
    }
    return array;
  }

  public <T extends Comparable<T>> Collection<T> sort(Collection<T> collection) {
    List<T> listToSort = new ArrayList<>(collection);
    for (int iterator = 0; iterator < listToSort.size() - 1; iterator++) {
      for (int indexFirstElementToCompare = 0; indexFirstElementToCompare < listToSort.size() - iterator - 1; indexFirstElementToCompare++) {
        if (listToSort.get(indexFirstElementToCompare).compareTo(listToSort.get(indexFirstElementToCompare + 1)) > 0) {
          changePositionFromCollection(listToSort, indexFirstElementToCompare);
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
