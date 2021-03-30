package com.iquestgroup.remotelearning.week8.w8p2.filler;

import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;

public class DeckOfCardsFiller {

  public static <T> T[] fill(T[] array, Generator<T> generator) {
    for (int index = 0; index < array.length; index++) {
      array[index] = generator.next();
    }
    return array;
  }
}
