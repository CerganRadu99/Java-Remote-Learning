package com.iquestgroup.remotelearning.week16.w16p1.database;

import com.iquestgroup.remotelearning.week16.w16p1.models.Student;
import com.iquestgroup.remotelearning.week16.w16p1.processors.AnnotationProcessor;

public class StudentDao extends Dao<Student>{

  protected StudentDao(AnnotationProcessor annotationProcessor) {
    super(annotationProcessor);
  }

  @Override
  public boolean add(Student student) {
    return false;
  }

  @Override
  public boolean update(Student student) {
    return false;
  }

  @Override
  public Student get(int id) {
    return null;
  }

  @Override
  public boolean delete(Student student) {
    return false;
  }
}
