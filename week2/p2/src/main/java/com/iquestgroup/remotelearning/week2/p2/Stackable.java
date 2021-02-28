package com.iquestgroup.remotelearning.week2.p2;

public interface Stackable<T> {

  void push(T value);

  T pop();

  T peek();

  boolean isEmpty();

  int size();
}
