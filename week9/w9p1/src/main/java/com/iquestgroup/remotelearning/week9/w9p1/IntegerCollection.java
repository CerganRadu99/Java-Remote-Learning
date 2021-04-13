package com.iquestgroup.remotelearning.week9.w9p1;

import java.util.ArrayList;
import java.util.Collection;

public class IntegerCollection implements MyCollection<Integer> {

  private final Collection<Integer> collection;

  public IntegerCollection() {
    collection = new ArrayList<>();
  }

  @Override
  public boolean containsAll(Collection<Integer> collection) {
    return this.collection.containsAll(collection);
  }

  @Override
  public boolean addAll(Collection<Integer> collection) {
    return this.collection.addAll(collection);
  }
}
