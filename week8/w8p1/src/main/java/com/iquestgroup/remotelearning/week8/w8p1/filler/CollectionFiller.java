package com.iquestgroup.remotelearning.week8.w8p1.filler;

import com.iquestgroup.remotelearning.week8.w8p1.models.CollectionType;
import com.iquestgroup.remotelearning.week8.w8p1.models.Generator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CollectionFiller {

  private static final CollectionType SET_COLLECTION = CollectionType.SET;
  private static final CollectionType LIST_COLLECTION = CollectionType.LIST;

  public static <T> Collection<T> fillCollection(CollectionType collectionType, Generator<T> generator, int length) {
    if (collectionType == SET_COLLECTION) {
      HashSet<T> hashSetToReturn = new HashSet<>();
      for (int index = 0; index < length; index++) {
        hashSetToReturn.add(generator.next());
      }
      return hashSetToReturn;

    } else if (collectionType == LIST_COLLECTION) {
      ArrayList<T> arraylistToReturn = new ArrayList<>();
      for (int index = 0; index < length; index++) {
        arraylistToReturn.add(generator.next());
      }
      return arraylistToReturn;
    }
    return null;
  }

  public static <K, V> Map<K, V> fillMap(Generator<K> keyGenerator, Generator<V> valueGenerator, int length) {
    Map<K, V> runningTrains = new HashMap<>();
    for (int index = 0; index < length; index++) {
      runningTrains.put(keyGenerator.next(), valueGenerator.next());
    }
    return runningTrains;
  }
}
