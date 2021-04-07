package com.iquestgroup.remotelearning.week9.w9p1;

import java.util.Collection;

public class MyCollectionImpl<E, T extends Collection<E>> implements MyCollection<T> {

  private final T collection;

  public MyCollectionImpl(T collection) {
    this.collection = collection;
  }

  @Override
  public boolean containsAll(T c) {
    return collection.containsAll(c);
  }

  @Override
  public boolean addAll(T c) {
    return collection.addAll(c);
  }
}
