package com.iquestgroup.remotelearning.week9.w9p1;

import java.util.Collection;

public interface MyCollection<T> {

  boolean containsAll(Collection<T> collection);

  boolean addAll(Collection<T> collection);
}
