package com.iquestgroup.remotelearning.week16.w16p1.database;

import com.iquestgroup.remotelearning.week16.w16p1.models.Address;
import com.iquestgroup.remotelearning.week16.w16p1.processors.AnnotationProcessor;

public class AddressDao extends Dao<Address>{

  protected AddressDao(AnnotationProcessor annotationProcessor) {
    super(annotationProcessor);
  }

  @Override
  public boolean add(Address address) {
    return false;
  }

  @Override
  public boolean update(Address address) {
    return false;
  }

  @Override
  public Address get(int id) {
    return null;
  }

  @Override
  public boolean delete(Address address) {
    return false;
  }
}
