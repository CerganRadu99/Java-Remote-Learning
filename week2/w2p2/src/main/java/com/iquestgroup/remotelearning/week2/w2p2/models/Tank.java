package com.iquestgroup.remotelearning.week2.w2p2.models;

public interface Tank<T> {

  void push(T value);

  T pop();

  boolean isEmpty();

  void fillTank();

  void emptyTank();

  boolean isFull();
}
