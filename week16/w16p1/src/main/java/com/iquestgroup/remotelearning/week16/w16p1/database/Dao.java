package com.iquestgroup.remotelearning.week16.w16p1.database;

import com.iquestgroup.remotelearning.week16.w16p1.processors.AnnotationProcessor;

public abstract class Dao<T> {
  protected AnnotationProcessor annotationProcessor;

  protected Dao(AnnotationProcessor annotationProcessor){
    this.annotationProcessor = annotationProcessor;
  }
  public abstract boolean add(T record);
  public abstract boolean update(T record);
  public abstract T get(int id);
  public abstract boolean delete(T record);
}
