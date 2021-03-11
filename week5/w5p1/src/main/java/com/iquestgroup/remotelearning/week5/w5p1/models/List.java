package com.iquestgroup.remotelearning.week5.w5p1.models;

public interface List<T> {

  void add(T element);

  T get(int position);

  boolean contains(T element);

  boolean containsAll(List<T> foreignList);

  int size();
}