package com.iquestgroup.remotelearning.week9.w9p2;

public class GenericBubbleSort {

  public <T extends Comparable<T>> void sort(T[] collection) {
    for (int i = 0; i < collection.length - 1; i++) {
      for (int j = 0; j < collection.length - i - 1; j++) {
        if (collection[j].compareTo(collection[j + 1]) > 0) {
          swap(collection, j, j + 1);
        }
      }
    }
  }

  private <T> void swap(T[] collection, int i, int j) {
    T temp = collection[i];
    collection[i] = collection[j];
    collection[j] = temp;
  }
}
