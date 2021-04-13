package com.iquestgroup.remotelearning.week9.w9p1;

import java.util.ArrayList;
import java.util.Collection;

public class StringCollection implements MyCollection<String> {

  private final Collection<String> collection;

  public StringCollection() {
    collection = new ArrayList<>();
  }

  @Override
  public boolean containsAll(Collection<String> collection) {
    return this.collection.containsAll(collection);
  }

  @Override
  public boolean addAll(Collection<String> collection) {
    return this.collection.addAll(collection);
  }
}
